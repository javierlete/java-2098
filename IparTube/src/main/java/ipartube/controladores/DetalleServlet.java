package ipartube.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ipartube.accesodatos.VideoDao;

@WebServlet("/detalle")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId=request.getParameter("id");
		Long id = Long.parseLong(sId);
		
		request.setAttribute("video", VideoDao.obtenerPorId(id));
		request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
	}
}
