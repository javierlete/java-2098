package ipartex.controladores;

import java.io.IOException;

import ipartex.accesodatos.UsuarioDao;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static ipartex.controladores.Globales.VISTAS;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(VISTAS + "registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, nombre, email, password);
		
		UsuarioDao.insertar(usuario);
		
		response.sendRedirect("index");
	}
}
