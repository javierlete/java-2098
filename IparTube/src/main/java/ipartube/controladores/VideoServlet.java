package ipartube.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ipartube.accesodatos.AutorDao;
import ipartube.accesodatos.VideoDao;

@WebServlet("/video")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		if(sId != null) {
			Long id = Long.parseLong(sId);
		
			request.setAttribute("video", VideoDao.obtenerPorId(id));
		}
		
		request.setAttribute("autores", AutorDao.obtenerTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/video.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin");
	}

}
