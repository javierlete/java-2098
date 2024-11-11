package ipartex.controladores;

import static ipartex.controladores.Globales.*;

import java.io.IOException;
import java.util.ArrayList;

import ipartex.accesodatos.MensajeDao;
import ipartex.modelos.Mensaje;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		ArrayList<Mensaje> mensajes;

		if (usuario != null && usuario.isAdmin()) {
			mensajes = MensajeDao.getMensajesConBorrados();
		} else {
			mensajes = MensajeDao.getMensajes();
		}

		request.setAttribute("mensajes", mensajes);

		request.getRequestDispatcher(VISTAS + "index.jsp").forward(request, response);
	}

}
