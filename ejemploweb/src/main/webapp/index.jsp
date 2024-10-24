<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<h1><%=almacen.getNombre()%></h1>

<ul>
	<%
	for (Producto p : almacen.getProductos()) {
	%>
	<li><a href="detalle.jsp?id=<%=p.getId()%>"><%=p.getNombre()%></a></li>
	<%
	}
	%>
</ul>

<%@ include file="includes/pie.jsp"%>