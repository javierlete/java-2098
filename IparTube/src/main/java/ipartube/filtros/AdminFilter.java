package ipartube.filtros;

import java.io.IOException;

import ipartube.modelos.Autor;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter({"/admin", "/videoform"})
public class AdminFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = -8094428104085743907L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Autor usuario = (Autor) session.getAttribute("usuario");
		
		if(usuario == null || !usuario.getEmail().equals("admin@email.net")) {
			res.sendRedirect("login");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
