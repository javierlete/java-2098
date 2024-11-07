<%@page import="ipartex.modelos.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");

for (Mensaje m : mensajes) {
%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-auto border-end">
			<div class="ratio ratio-1x1" style="width: 80px">
				<img src="imgs/<%=m.getUsuario().getId()%>.jpg" width="40" class="rounded-circle p-3" alt="...">
			</div>
		</div>
		<div class="col">
			<div class="card-body">
				<h5 class="card-title">
					<%=m.getUsuario().getNombre()%>
					<small class="fs-6 text-body-secondary"><%=m.getFechaFormateada()%></small>
				</h5>
				<p class="card-text"><%=m.getTexto()%></p>
				<p class="card-text">
					<small class="text-body-secondary"><i class="bi bi-heart"></i>
						<%=m.getNumeroLesGusta()%></small>
				</p>
			</div>
		</div>
	</div>
</div>

<%
}
%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>