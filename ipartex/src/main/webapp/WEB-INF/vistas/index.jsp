<%@page import="ipartex.accesodatos.MensajeDao"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="ipartex.modelos.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
if (usuario != null) {
%>

<div class="card mb-3">
	<div class="row g-0">
		<div class="col-auto border-end">
			<div class="ratio ratio-1x1" style="width: 80px">
				<img src="imgs/<%=usuario.getId()%>.jpg" width="40"
					class="rounded-circle p-3" alt="...">
			</div>
		</div>
		<div class="col">
			<form class="card-body" action="mensaje" method="post">
				<h5 class="card-title">
					<%=usuario.getNombre()%>
					<small class="fs-6 text-body-secondary"><%=LocalDateTime.now().format(Mensaje.FORMATEADOR_FECHA)%></small>
				</h5>
				<p class="input-group card-text">
					<input class="form-control" name="texto">
					<button class="btn btn-primary">Enviar</button>
				</p>
			</form>
		</div>
	</div>
</div>

<%
}
%>

<%
@SuppressWarnings("unchecked")
ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) request.getAttribute("mensajes");

for (Mensaje m : mensajes) {
%>

<div id="m<%=m.getId()%>" class="card mb-3"
	style="scroll-margin-top: 60px">
	<div class="row g-0 flex-nowrap">
		<div class="col-auto border-end">
			<div class="ratio ratio-1x1" style="width: 80px">
				<img src="imgs/<%=m.getUsuario().getId()%>.jpg" width="40"
					class="rounded-circle p-3" alt="...">
			</div>
		</div>
		<div class="col overflow-hidden">
			<div class="card-body">
				<div class="card-title d-flex justify-content-between">
					<h5>
						<%=m.getUsuario().getNombre()%>
						<small class="fs-6 text-body-secondary"><%=m.getFechaFormateada()%></small>
					</h5>
					<%
					if (usuario != null && usuario.getId() == m.getUsuario().getId()) {
					%>
					<a
						onclick="return confirm('¿Estás seguro de eliminar este mensaje?')"
						href="borrar?id=<%=m.getId()%>" class="btn-close"
						aria-label="Close"></a>
					<%
					}
					%>
				</div>
				<p class="card-text text-truncate"><%=m.getTexto()%></p>
				<p class="card-text">
					<small class="text-body-secondary"> <a
						onclick="return megusta(<%=m.getId()%>)"
						href="megusta?id=<%=m.getId()%>"><%
 if (usuario != null && MensajeDao.legusta(usuario.getId(), m.getId())) {
 %><i class="text-danger bi bi-heart-fill"></i><%
 } else {
 %><i class="bi bi-heart"></i><%
 }
 %></a> <span class="numero-megusta"><%=m.getNumeroLesGusta()%></span></small>
				</p>
			</div>
		</div>
	</div>
</div>

<%
}
%>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>