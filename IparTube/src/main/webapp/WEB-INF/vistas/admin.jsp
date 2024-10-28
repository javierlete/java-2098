<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table table-striped table-hover table-bordered">
	<caption>Videos</caption>

	<thead class="table-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Autor</th>
			<th>OPCIONES</th>
		</tr>
	</thead>

	<tbody>
		<%
		for (int i = 1; i <= 20; i++) {
		%>
		<tr>
			<th><%=i %></th>
			<td>Nombre <%=i %></td>
			<td>Descripción <%=i %></td>
			<td>Autor <%=i %></td>
			<td>
				<a class="btn btn-sm btn-primary" href="video?id=<%=i %>">Editar</a>
				<a class="btn btn-sm btn-danger" href="video-borrar?id=<%=i %>">Borrar</a>
			</td>
		</tr>
		<%
		}
		%>
	</tbody>
	<tfoot class="table-dark">
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<a class="btn btn-sm btn-primary" href="video">Añadir</a>
			</td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>