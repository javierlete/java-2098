<%@ page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
LocalTime ahora = LocalTime.now();
%>
<!DOCTYPE html>
<html>
<head>
<title>Ejemplo de JSP</title>

<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
	<h1>Ejemplo de JSP</h1>
	<p>Hola</p>
	<p>Este es un texto enviado desde una JSP</p>
	<p>
		Son las
		<%=String.format("%tT", ahora)%></p>
	<pre>
		<%
		for (int num = 0; num <= ahora.getSecond(); num++) {
		%>*<%
		}
		%>
	</pre>

	<%
	if (ahora.getSecond() % 2 == 0) {
		out.println("<p>Son pares</p>");
	} else {
	%>
	<p>Son impares</p>
	<%
	}
	%>
</body>
</html>