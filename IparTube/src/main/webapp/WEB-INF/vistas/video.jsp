<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Edición de video</h2>

<form action="video" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm-10">
			<input type="number" readonly class="form-control" id="id" name="id" value="2">
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" class="form-control is-invalid" id="nombre" name="nombre" value="Video 2">
			<div class="invalid-feedback">
				El nombre debe tener como mínimo 3 caracteres
			</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<input type="text" class="form-control is-invalid" id="descripcion" name="descripcion" value="Descripción del video">
			<div class="invalid-feedback">
				La descripción no debe tener más de 150 caracteres
			</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="autor" class="col-sm-2 col-form-label">Autor</label>
		<div class="col-sm-10">
			<select  class="form-select is-invalid" id="autor" name="autor">
				<option>Autor 1</option>
				<option selected>Autor 2</option>
				<option>Autor 3</option>
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