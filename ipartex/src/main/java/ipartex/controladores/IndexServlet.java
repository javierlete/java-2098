package ipartex.controladores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var mensajes = new ArrayList<Mensaje>();
		
		Usuario javier = new Usuario(1L, "Javier Lete", "javier@email.net", null);
		Usuario pepe = new Usuario(2L, "Pepe Pérez", "pepe@email.net", null);
		
		Mensaje mensaje1 = new Mensaje(1L, javier, LocalDateTime.now(), "En una clase de informática de cuyo nombre no me da la gana de acordarme");
		
		mensaje1.getUsuariosLesGusta().add(pepe);
		mensaje1.getUsuariosLesGusta().add(javier);
		
		mensajes.add(mensaje1);
		mensajes.add(new Mensaje(2L, pepe, LocalDateTime.now(), "me da la gana de acordarme"));
		mensajes.add(new Mensaje(3L, pepe, LocalDateTime.now(), "En una clase de informática me da la gana de acordarme"));
		mensajes.add(new Mensaje(4L, javier, LocalDateTime.now(), "nombre no me da la gana de acordarme"));
		
		request.setAttribute("mensajes", mensajes);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

}
