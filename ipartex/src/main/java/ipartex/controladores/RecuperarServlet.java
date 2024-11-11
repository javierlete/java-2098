package ipartex.controladores;

import java.io.IOException;

import ipartex.accesodatos.MensajeDao;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recuperar")
public class RecuperarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		if(usuario == null || !usuario.isAdmin()) {
			throw new RuntimeException("No se permite recuperar mensajes si no eres administrador");
		}
		
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		MensajeDao.recuperar(id);
		
		response.sendRedirect("index");
	}

}
