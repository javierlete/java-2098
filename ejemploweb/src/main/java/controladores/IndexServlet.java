package controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		globales.Global.almacen.getProductos();
		request.setAttribute("almacen", globales.Global.almacen);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
