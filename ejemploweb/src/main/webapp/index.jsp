<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<%
Almacen almacen = (Almacen) request.getAttribute("almacen");
%>

<h1><%=almacen.getNombre()%></h1>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<%
	for (Producto p : almacen.getProductos()) {
	%>
	<div class="col">
		<div class="card h-100">
			<img src="https://picsum.photos/400/300?<%=p.getId()%>"
				class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">
					<a class="text-dark link-underline-light stretched-link"
						href="detalle?id=<%=p.getId()%>"><%=p.getNombre()%></a>
				</h5>
				<p class="card-text"><%=p.getPrecio()%></p>
			</div>
			<div class="card-footer">
				<small class="text-body-secondary">Last updated 3 mins ago</small>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>

<%@ include file="includes/pie.jsp"%>