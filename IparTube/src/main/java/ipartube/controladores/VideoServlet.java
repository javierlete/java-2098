package ipartube.controladores;

import java.io.IOException;

import ipartube.accesodatos.AutorDao;
import ipartube.accesodatos.VideoDao;
import ipartube.modelos.Autor;
import ipartube.modelos.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger información de la petición
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String url = request.getParameter("url");

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
			request.getRequestDispatcher("/WEB-INF/vistas/video.jsp").forward(request, response);
			return;
		}

		if (video.getId() == null) {
			VideoDao.insertar(video);
		} else {
			VideoDao.modificar(video, usuario.isAdmin());
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
