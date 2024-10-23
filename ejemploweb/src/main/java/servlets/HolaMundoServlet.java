package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("""
				<!DOCTYPE html>
				<html>
				<head>
				<title>Ejemplo de Servlet</title>
				</head>
				<body>
					<h1>Ejemplo de Servlet</h1>
					<p>Hola</p>
					<p>Este es un texto enviado desde una Servlet escrita en Java</p>
				</body>
				</html>
				""");
	}
}
