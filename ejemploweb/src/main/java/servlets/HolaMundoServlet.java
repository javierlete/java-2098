package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

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
		
		LocalTime ahora = LocalTime.now();
		
		out.println(String.format("""
				<!DOCTYPE html>
				<html>
				<head>
					<title>Ejemplo de Servlet</title>
					
					<link rel="stylesheet" href="css/estilos.css">
				</head>
				<body>
					<h1>Ejemplo de Servlet</h1>
					<p>Hola</p>
					<p>Este es un texto enviado desde una Servlet escrita en Java</p>
					<p>Son las %tT</p>
				""", ahora));
		
		out.print("<pre>");
		
		for(int num = 0; num <= ahora.getSecond(); num++) {
			out.print("*");
		}
		
		out.println("</pre>");
		
		if(ahora.getSecond() % 2 == 0) {
			out.println("<p>Son pares</p>");
		} else {
			out.println("<p>Son impares</p>");
		}
		
		out.println("</body></html>");
	}
}
