<%@ page import="poo.pojos.Producto"%>
<%@ page import="poo.pojos.Almacen"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
Almacen almacen = new Almacen("Bilbao");

String sId = request.getParameter("id");

Long id = Long.parseLong(sId);

Producto producto = almacen.getProductoPorId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=producto.getNombre() %></title>
</head>
<body>
<h1><%=producto.getNombre() %></h1>

<dl>
	<dt>Id</dt>
	<dd><%=producto.getId() %></dd>
	
	<dt>Nombre</dt>
	<dd><%=producto.getNombre() %></dd>
	
	<dt>Precio</dt>
	<dd><%=producto.getPrecio() %></dd>
</dl>

</body>
</html>