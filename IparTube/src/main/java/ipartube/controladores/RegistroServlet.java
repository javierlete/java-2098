package ipartube.controladores;

import java.io.IOException;

import ipartube.accesodatos.AutorDao;
import ipartube.modelos.Autor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");

		// 2. Convertir los datos necesarios

		// 3. Crear objetos de modelo
		Autor autor = new Autor(null, email, password, nombre, descripcion);

		// 4. Ejecutar la lógica de negocio
		AutorDao.insertar(autor);

		// 5. Preparar información para la siguiente petición
		// 6. Pasar a la siguiente vista
		response.sendRedirect("index");
	}

}
