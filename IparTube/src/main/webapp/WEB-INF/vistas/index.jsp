<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row row-cols-1 row-cols-md-3 g-4">
	<%
	for (int i = 1; i <= 20; i++) {
	%>
	<div class="col">
		<div class="card h-100">
			<img src="https://picsum.photos/400/225?<%=i%>" class="card-img-top"
				alt="...">
			<div class="card-body">
				<h5 class="card-title">
					<a class="link-underline-light text-dark stretched-link" href="detalle?id=<%=i%>">Video <%=i%></a>
				</h5>
				<p class="card-text pb-5">
					Descripción
					<%=i%></p>
			</div>
			<div class="card-footer text-end z-2 position-absolute bottom-0 w-100">
				<small class="text-body-secondary"><a href="autor?id=<%=i%>">Autor <%=i%></a></small>
			</div>
		</div>
	</div>
	<%
	}
	%>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
