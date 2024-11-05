<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>

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
		for (Video v: videos) {
		%>
		<tr>
			<th><%=v.getId()%></th>
			<td><%=v.getNombre()%></td>
			<td><%=v.getDescripcion()%></td>
			<td><%=v.getAutor().getNombre()%></td>
			<td><a class="btn btn-sm btn-primary" href="videoform?id=<%=v.getId()%>">Editar</a>
				<a class="btn btn-sm btn-danger" href="video-borrar?id=<%=v.getId()%>">Borrar</a>
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
			<td><a class="btn btn-sm btn-primary" href="videoform">Añadir</a></td>
		</tr>
	</tfoot>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>