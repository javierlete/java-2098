<%@page import="ipartube.modelos.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Autor> autores = (ArrayList<Autor>) request.getAttribute("autores");
Video video = (Video) request.getAttribute("video");
%>

<h2>Edición de video</h2>

<form action="video" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id"
				value="<%=video == null ? "" : video.getId()%>">
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="nombre"
				name="nombre" value="<%=video == null ? "" : video.getNombre()%>">
			<div class="invalid-feedback">El nombre debe tener como mínimo
				3 caracteres</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="url" class="col-sm-2 col-form-label">url</label>
		<div class="col-sm-10">
			<input type="url" class="form-control" id="url" name="url"
				value="<%=video == null ? "" : video.getUrl()%>">
			<div class="invalid-feedback">La URL debe ser válida</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<textarea class="form-control" id="descripcion"
				name="descripcion"><%=video == null ? "" : video.getDescripcion()%></textarea>
			<div class="invalid-feedback">La descripción no debe tener más
				de 150 caracteres</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="autor" class="col-sm-2 col-form-label">Autor</label>
		<div class="col-sm-10">
			<select class="form-select" id="autor" name="autor">
				<option value="0">Ninguno seleccionado</option>
				<%
				for (Autor a : autores) {
				%>
				<option <%=video != null && video.getAutor().getId() == a.getId() ? "selected" : "" %> value="<%=a.getId()%>"><%=a.getNombre()%></option>
				<%
				}
				%>
			</select>
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