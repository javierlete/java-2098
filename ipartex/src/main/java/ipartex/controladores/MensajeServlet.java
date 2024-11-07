package ipartex.controladores;

import java.io.IOException;
import java.time.LocalDateTime;

import ipartex.accesodatos.MensajeDao;
import ipartex.modelos.Mensaje;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mensaje")
public class MensajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		String texto = request.getParameter("texto");

		Mensaje mensaje = new Mensaje(null, usuario, LocalDateTime.now(), texto, 0L);
		
		MensajeDao.insertar(mensaje);
		
		response.sendRedirect("index");
	}
}
