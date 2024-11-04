<%@page import="ipartube.modelos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipartube.modelos.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
Autor autor = (Autor) request.getAttribute("autor");

@SuppressWarnings("unchecked")
ArrayList<Video> videos = (ArrayList<Video>) request.getAttribute("videos");
%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-md-4">
			<img src="https://picsum.photos/400/400"
				class="img-fluid rounded-start" alt="...">
		</div>
		<div class="col-md-8">
			<div class="card-body">
				<h2 class="card-title display-1"><%=autor.getNombre()%></h2>
				<p class="card-text"><%=autor.getDescripcion()%></p>
			</div>
		</div>
	</div>
</div>

<div>
	<h3>Mis videos</h3>
</div>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<%
	for (Video v : videos) {
	%>
	<div class="col">
		<div class="card h-100">
			<img src="https://picsum.photos/400/225?<%=v.getId()%>"
				class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">
					<a class="link-underline-light text-dark stretched-link"
						href="detalle?id=<%=v.getId()%>"><%=v.getNombre()%></a>
				</h5>
				<p class="card-text pb-5">
					<%=v.getDescripcion()%></p>
			</div>
		</div>
	</div>
	<%
	}
	%>
	<%
	if (autor.getId() == usuario.getId()) {
	%>
	<div class="col">
		<div class="card h-100 border-primary">
			<div class="ratio ratio-16x9 card-img-top">
				<img src="imgs/plus-lg.svg" class=""/>
			</div>
			<div class="card-body">
				<h5 class="card-title">
					<a class="link-underline-light text-dark stretched-link"
						href="autor-video">Añadir video</a>
				</h5>
				<p class="card-text pb-5">
					Pulsa aquí para añadir un nuevo video</p>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>