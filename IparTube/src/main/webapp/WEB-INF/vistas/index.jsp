<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<%
	for (Video v : videos) {
	%>
	<div class="col">
		<div class="card h-100">
			<div class="ratio ratio-16x9 card-img-top">
				<div class="text-center bg-secondary-subtle rounded-top border-bottom border-secondary">
					<img src="miniaturas/<%=v.getId()%>.jpg" class="h-100 rounded-top" alt="...">
				</div>
			</div>
			<div class="card-body">
				<h5 class="card-title">
					<a class="link-underline-light text-dark stretched-link"
						href="detalle?id=<%=v.getId()%>"><%=v.getNombre()%></a>
				</h5>
				<p class="card-text pb-5"><%=v.getDescripcion()%></p>
			</div>
			<div
				class="card-footer text-end z-2 position-absolute bottom-0 w-100">
				<small class="text-body-secondary"><a
					href="autor?id=<%=v.getAutor().getId()%>"><%=v.getAutor().getNombre()%></a></small>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
