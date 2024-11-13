package ipargram.controladores;

import java.io.IOException;

import ipargram.accesodatos.EntradaAccesoDatos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		var entrada = EntradaAccesoDatos.obtenerPorId(id);
		
		request.setAttribute("entrada", entrada);
		
		request.getRequestDispatcher("/WEB-INF/vistas/entrada.jsp").forward(request, response);
	}
}
