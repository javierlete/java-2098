<%@ page import="poo.pojos.Producto"%>
<%@ page import="poo.pojos.Almacen"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Almacen almacen = new Almacen("Bilbao"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=almacen.getNombre() %></title>
</head>
<body>
<h1><%=almacen.getNombre() %></h1>

<ul>
<% for(Producto p: almacen.getProductos()) { %>
	<li><%=p.getNombre() %></li>
<% } %>
</ul>

</body>
</html>