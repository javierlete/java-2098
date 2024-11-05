package ipartube.controladores;

import java.io.IOException;

import ipartube.accesodatos.VideoDao;
import ipartube.modelos.Autor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video-borrar")
public class VideoBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Autor usuario = (Autor) request.getSession().getAttribute("usuario");

		String sId = request.getParameter("id");
		Long id = Long.parseLong(sId);

		if (usuario.isAdmin()) {
			VideoDao.borrar(id);
			response.sendRedirect("admin");
		} else {
			VideoDao.borrar(id, usuario.getId());
			response.sendRedirect("autor?id=" + usuario.getId());
		}
	}
}
