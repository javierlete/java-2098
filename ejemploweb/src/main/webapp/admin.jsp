<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/cabecera.jsp"%>

<table class="table table-bordered table-striped table-hover">
	<caption>Productos</caption>
	
	<thead class="table-dark">
		<tr>
			<th class="text-end">Id</th>
			<th>Nombre</th>
			<th class="text-end">Precio</th>
			<th>Opciones</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (Producto p : almacen.getProductos()) {
		%>
		<tr>
			<th class="text-end"><%=p.getId() %></th>
			<td><%=p.getNombre() %></td>
			<td class="text-end"><%=p.getPrecio() %> €</td>
			<td>
				<a class="btn btn-primary" href="form.jsp?id=<%=p.getId()%>">Editar</a>
				<a class="btn btn-danger" href="#">Borrar</a>
			</td>
		</tr>
		<% } %>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a class="btn btn-primary" href="form.jsp">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="includes/pie.jsp"%>