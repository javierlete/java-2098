<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>
<%
Producto producto = (Producto) request.getAttribute("producto");
%>

<h1><%=producto.getNombre()%></h1>

<div class="card mb-3" style="max-width: 540px;">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://picsum.photos/400/400"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h5 class="card-title"><%=producto.getNombre()%></h5>
				<p class="card-text"><%=producto.getId()%></p>
				<p class="card-text"><%=producto.getPrecio()%></p>
				<p class="card-text">
					<small class="text-body-secondary">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
</div>

<%@ include file="includes/pie.jsp"%>