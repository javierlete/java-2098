<%@page import="ipargram.modelos.Entrada"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
var entrada = (Entrada) request.getAttribute("entrada");
%>

<div class="card text-bg-dark">
	<img src="imgs/<%=entrada.getId() %>.jpg" class="card-img" alt="...">
	<div class="card-img-overlay">
		<h5 class="card-title"><%=entrada.getTitulo() %></h5>
		<p class="card-text">
			<small><%=entrada.getFechaHoraFormateada() %></small>
		</p>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
