package ipartex.controladores;

import java.io.IOException;

import ipartex.accesodatos.UsuarioDao;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = UsuarioDao.buscarPorEmail(email);
		
		if(usuario == null || !usuario.getPassword().equals(password)) {
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("usuario", usuario);
		
		response.sendRedirect("index");
	}
}
