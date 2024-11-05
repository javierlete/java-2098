<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Video formVideo = (Video) request.getAttribute("video");
%>
<form action="video" method="post" enctype="multipart/form-data">
	<input type="hidden" id="id" name="id"
		value="<%=formVideo == null ? "" : formVideo.getId()%>">

	<div class="row mb-3">
		<label for="miniatura" class="col-sm-3 col-form-label">Miniatura</label>
		<div class="col-sm">
			<input type="file" class="form-control" id="miniatura"
				name="miniatura" value="" accept="image/jpeg">
			<div class="invalid-feedback"></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
		<div class="col-sm">
			<input type="text"
				class="form-control <%=formVideo != null && formVideo.getErrorNombre() != null ? "is-invalid" : ""%>"
				id="nombre" name="nombre"
				value="<%=formVideo == null ? "" : formVideo.getNombre()%>">
			<div class="invalid-feedback"><%=formVideo != null && formVideo.getErrorNombre() != null ? formVideo.getErrorNombre() : ""%></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="url" class="col-sm-3 col-form-label">Url</label>
		<div class="col-sm">
			<input type="url"
				class="form-control <%=formVideo != null && formVideo.getErrorUrl() != null ? "is-invalid" : ""%>"
				id="url" name="url"
				value="<%=formVideo == null ? "" : formVideo.getUrl()%>">
			<div class="invalid-feedback"><%=formVideo != null && formVideo.getErrorUrl() != null ? formVideo.getErrorUrl() : ""%></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripcion" class="col-sm-3 col-form-label">Descripción</label>
		<div class="col-sm">
			<textarea
				class="form-control <%=formVideo != null && formVideo.getErrorDescripcion() != null ? "is-invalid" : ""%>"
				id="descripcion" name="descripcion"><%=formVideo == null ? "" : formVideo.getDescripcion()%></textarea>
			<div class="invalid-feedback"><%=formVideo != null && formVideo.getErrorDescripcion() != null ? formVideo.getErrorDescripcion() : ""%></div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="" class="col-sm-3 col-form-label"></label>
		<div class="col-sm">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<%
			if (formVideo != null) {
			%>
			<a onclick="return confirm('¿Estás seguro de borrar este video?')"
				href="video-borrar?id=<%=formVideo.getId()%>" class="btn btn-danger">Borrar</a>
			<%
			}
			%>
		</div>
	</div>

</form>
