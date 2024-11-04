<%@page import="ipartube.modelos.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
%>

<h2>Registro de autor</h2>

<form action="registro" method="post">

	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="email"
				name="email" value="asdf@asdf.asdf">
			<div class="invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="password"
				name="password" value="Una contraseña">
			<div class="invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre"
				name="nombre" value="Un nombre">
			<div class="invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<textarea class="form-control " id="descripcion"
				name="descripcion">La descripción</textarea>
			<div class="invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="" class="col-sm-2 col-form-label"></label>
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>
	</div>

</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>