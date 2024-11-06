package ipartube.controladores;

import java.io.IOException;

import ipartube.accesodatos.AutorDao;
import ipartube.accesodatos.VideoDao;
import ipartube.modelos.Autor;
import ipartube.modelos.Video;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/video")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("REFERER: " + request.getHeader("referer"));

		ServletContext servletContext = request.getServletContext();

		String rutaMiniaturas = servletContext.getRealPath("/miniaturas");
		String rutaVideos = servletContext.getRealPath("/videos");

		System.out.println("RUTA REAL VIDEOS: " + rutaVideos);
		System.out.println("RUTA REAL MINIATURAS: " + rutaMiniaturas);

		// 1. Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String url = request.getParameter("url");

		Part videoPart = request.getPart("video");
		Part miniaturaPart = request.getPart("miniatura");

		if (videoPart != null && !videoPart.getSubmittedFileName().isBlank()) {
			url = "videos/" + videoPart.getSubmittedFileName();
		}

		Autor usuario = (Autor) request.getSession().getAttribute("usuario");

		String sIdAutor;

		if (usuario.isAdmin()) {
			sIdAutor = request.getParameter("autor");
		} else {
			sIdAutor = usuario.getId().toString();
		}

		// 2. Convertir los datos necesarios
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		Long idAutor = Long.parseLong(sIdAutor);

		// 3. Crear objetos de modelo
		Autor autor = new Autor(idAutor, null, null, null, null);
		Video video = new Video(id, nombre, descripcion, url, autor);

		// 4. Ejecutar la lógica de negocio
		if (!video.isCorrecto()) {
			// 5. Preparar información para la siguiente petición
			request.setAttribute("video", video);
			request.setAttribute("autores", AutorDao.obtenerTodos());

			// 6. Pasar a la siguiente vista
			request.getRequestDispatcher(request.getHeader("referer").replace(request.getContextPath(), "")
					.replace(request.getHeader("origin"), "")).forward(request, response);
			return;
		}

		if (video.getId() == null) {
			video = VideoDao.insertar(video);
		} else {
			VideoDao.modificar(video, usuario.isAdmin());
		}

		if (miniaturaPart != null && !miniaturaPart.getSubmittedFileName().isBlank()) {
			miniaturaPart.write(rutaMiniaturas + "/" + video.getId() + ".jpg");
		}

		if (videoPart != null && !videoPart.getSubmittedFileName().isBlank()) {
			videoPart.write(rutaVideos + "/" + videoPart.getSubmittedFileName());
		}

		// 5. Preparar información para la siguiente petición
		// 6. Pasar a la siguiente vista
		if (usuario.isAdmin()) {
			response.sendRedirect("admin");
		} else {
			response.sendRedirect("autor?id=" + usuario.getId());
		}
	}

}
