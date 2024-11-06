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

<%-- <p><%=video %></p> --%>

<form action="video" method="post" enctype="multipart/form-data">
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
			<input type="text" class="form-control <%= video != null && video.getErrorNombre() != null ? "is-invalid" : ""%>" id="nombre"
				name="nombre" value="<%=video == null ? "" : video.getNombre()%>">
			<div class="invalid-feedback"><%= video != null && video.getErrorNombre() != null ? video.getErrorNombre() : "" %></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="url" class="col-sm-2 col-form-label">Url</label>
		<div class="col-sm-10">
			<input type="url" class="form-control <%= video != null && video.getErrorUrl() != null ? "is-invalid" : ""%>" id="url" name="url"
				value="<%=video == null ? "" : video.getUrl()%>">
			<div class="invalid-feedback"><%= video != null && video.getErrorUrl() != null ? video.getErrorUrl() : "" %></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<textarea class="form-control <%= video != null && video.getErrorDescripcion() != null ? "is-invalid" : ""%>" id="descripcion"
				name="descripcion"><%=video == null ? "" : video.getDescripcion()%></textarea>
			<div class="invalid-feedback"><%= video != null && video.getErrorDescripcion() != null ? video.getErrorDescripcion() : "" %></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="autor" class="col-sm-2 col-form-label">Autor</label>
		<div class="col-sm-10">
			<select class="form-select <%= video != null && video.getErrorAutor() != null ? "is-invalid" : ""%>" id="autor" name="autor">
				<option value="0">Ninguno seleccionado</option>
				<%
				for (Autor a : autores) {
				%>
				<option <%=video != null && video.getAutor().getId() == a.getId() ? "selected" : "" %> value="<%=a.getId()%>"><%=a.getNombre()%></option>
				<%
				}
				%>
			</select>
			<div class="invalid-feedback"><%= video != null && video.getErrorAutor() != null ? video.getErrorAutor() : "" %></div>
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