<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="formulario" method="post">
	<div class="row mb-3">
		<label for="titulo" class="col-sm-3 col-md-2 col-form-label">Título</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="titulo" name="titulo">
		</div>
	</div>
	<div class="row mb-3">
		<label for="fecha-hora" class="col-sm-3 col-md-2 col-form-label">Fecha y hora</label>
		<div class="col-sm">
			<input type="datetime-local" class="form-control" id="fecha-hora" name="fecha-hora" value="<%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))%>">
		</div>
	</div>
	
	<button type="submit" class="btn btn-primary">Guardar</button>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
