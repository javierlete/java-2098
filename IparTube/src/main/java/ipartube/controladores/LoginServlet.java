package ipartube.controladores;

import java.io.IOException;

import ipartube.accesodatos.AutorDao;
import ipartube.modelos.Autor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. Convertir los datos necesarios

		// 3. Crear objetos de modelo

		// 4. Ejecutar la lógica de negocio
		Autor autor = AutorDao.obtenerPorEmail(email);
		
		if(autor != null && password.equals(autor.getPassword())) {
			// 5. Preparar información para la siguiente petición
			HttpSession session = request.getSession();
			session.setAttribute("usuario", autor);
			
			// 6. Pasar a la siguiente vista
			response.sendRedirect("index");
		} else {
			// 5. Preparar información para la siguiente petición
			// 6. Pasar a la siguiente vista

			response.sendRedirect("login");
		}
	}

}
