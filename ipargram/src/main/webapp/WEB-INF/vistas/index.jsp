<%@page import="ipargram.modelos.Entrada"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
var entradas = (ArrayList<Entrada>)request.getAttribute("entradas");
%>

<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	<% for(Entrada entrada: entradas) { %>
	<div class="col">
		<div class="card h-100">
			<img src="imgs/<%=entrada.getId() %>.jpg" class="card-img-top" alt="...">
			<div class="card-body d-flex">
				<h5 class="card-title align-self-end"><%=entrada.getTitulo() %></h5>
			</div>
			<div class="card-footer">
				<small class="text-body-secondary"><%=entrada.getFechaHoraFormateada() %></small>
			</div>
		</div>
	</div>
	<% } %>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
