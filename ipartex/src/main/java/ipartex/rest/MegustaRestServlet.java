package ipartex.rest;

import java.io.IOException;

import ipartex.accesodatos.MensajeDao;
import ipartex.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/megusta")
public class MegustaRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		String sId = request.getParameter("id");
		
		if(usuario == null) {
			System.out.println("EL USUARIO NO ESTÁ LOGUEADO");
			response.getWriter().write("El usuario no está logueado");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Long id = Long.parseLong(sId);
		
		if(MensajeDao.legusta(usuario.getId(), id)) {
			System.out.println("QUITAR ME GUSTA");
			MensajeDao.quitarMegusta(usuario.getId(), id);
		} else {
			System.out.println("PONER ME GUSTA");
			MensajeDao.agregarMegusta(usuario.getId(), id);
		}
	}

}
