<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
Video video = (Video) request.getAttribute("video");
%>

<div class="row">
	<div class="offset-lg-2 col-lg-8">
		<div class="card">
			<div class="ratio ratio-16x9">
				<iframe src="<%=video.getUrl()%>" title="YouTube video player"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
			</div>
			<div class="card-body">
				<div class="d-flex">
					<div class="pe-4"><%=video.getAutor().getNombre()%></div>
					<%
					if (usuario != null && usuario.getId() == video.getAutor().getId()) {
					%>
					<div class="w-100">
						<%@ include file="/WEB-INF/vistas/includes/form-video-autor.jsp"%>
					</div>
					<%
					} else {
					%>
					<div>
						<h5 class="card-title"><%=video.getNombre()%></h5>
						<p class="card-text"><%=video.getDescripcion()%></p>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>