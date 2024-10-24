<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>
<% 
String sId = request.getParameter("id");

Long id = Long.parseLong(sId);

Producto producto = almacen.getProductoPorId(id);
%>

<h1><%=producto.getNombre() %></h1>

<dl>
	<dt>Id</dt>
	<dd><%=producto.getId() %></dd>
	
	<dt>Nombre</dt>
	<dd><%=producto.getNombre() %></dd>
	
	<dt>Precio</dt>
	<dd><%=producto.getPrecio() %></dd>
</dl>

<%@ include file="includes/pie.jsp"%>