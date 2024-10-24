<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<%
String sId = request.getParameter("id");

Producto producto = null;

if (request.getMethod().equals("GET")) {
	if (sId != null) {
		Long id = Long.parseLong(sId);
		producto = almacen.getProductoPorId(id);
	}
} else {
	String nombre = request.getParameter("nombre");
	String sPrecio = request.getParameter("precio");
	
	Long id = sId.isBlank() ? null : Long.parseLong(sId);
	BigDecimal precio = new BigDecimal(sPrecio);
	
	producto = new Producto(id, nombre, precio);
	
	if(id == null) {
		almacen.meterProducto(producto);
	} else {
		almacen.modificarProducto(producto);
	}
	
	response.sendRedirect("admin.jsp");
	return;
}
%>

<form action="form.jsp" method="post">
	<div class="row mb-3">
		<label for="id" class="col-sm-2 col-form-label">Id</label>
		<div class="col-sm">
			<input type="number" readonly class="form-control" id="id" name="id"
				value="<%=producto == null ? "" : producto.getId()%>">
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm">
			<input type="text" class="form-control" id="nombre" name="nombre"
				value="<%=producto == null ? "" : producto.getNombre()%>">
		</div>
	</div>

	<div class="row mb-3">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm">
			<input type="number" step=".01" class="form-control" id="precio"
				name="precio"
				value="<%=producto == null ? "" : producto.getPrecio()%>">
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Guardar</button>
</form>

<%@ include file="includes/pie.jsp"%>