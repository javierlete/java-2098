package ipartex.controladores;

import java.io.IOException;

import ipartex.accesodatos.MensajeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static ipartex.controladores.Globales.VISTAS;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mensajes", MensajeDao.getMensajes());
		
		request.getRequestDispatcher(VISTAS + "index.jsp").forward(request, response);
	}

}
