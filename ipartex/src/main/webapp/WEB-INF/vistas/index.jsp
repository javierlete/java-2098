<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
for (int i = 1; i <= 20; i++) {
%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-auto">
			<img src="https://picsum.photos/40/40?<%=i%>"
				class="img-fluid rounded-circle mt-3 ms-3" alt="...">
		</div>
		<div class="col">
			<div class="card-body">
				<h5 class="card-title">
					Usuario
					<%=i%>
					<small class="fs-6 text-body-secondary"><%=java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))%></small>
				</h5>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">
					<small class="text-body-secondary"><i class="bi bi-heart"></i> <%=i*100 %></small>
				</p>
			</div>
		</div>
	</div>
</div>

<%
}
%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>