<%@page import="ipartube.modelos.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ipartube.modelos.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<%
Video video = (Video) request.getAttribute("video");
%>

<h2 class="text-center">Edición de video</h2>

<div class="row">
	<div class="col-sm-2"></div>

	<div class="col-sm-8">
		<%@ include file="/WEB-INF/vistas/includes/form-video-autor.jsp"%>
	</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>