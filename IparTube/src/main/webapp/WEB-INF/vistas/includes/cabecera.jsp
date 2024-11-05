<%@page import="ipartube.modelos.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Autor usuario = (Autor) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>IparTube</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/2.1.8/css/dataTables.bootstrap5.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">IparTube</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<%
					if (usuario != null) {
					%>
					<li class="nav-item"><a class="nav-link"
						href="autor?id=<%=usuario.getId()%>"><%=usuario.getNombre()%></a></li>
					<%
					}
					if (usuario != null && usuario.isAdmin()) {
					%>
					<li class="nav-item"><a class="nav-link" href="admin">Administración</a></li>
					<%
					}
					if (usuario == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="registro">Registro
							de autor</a></li>

					<li class="nav-item"><a class="nav-link" href="login">Iniciar
							sesión</a></li>
					<%
					}

					if (usuario != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<%="<main class='container mt-4 mb-5 pb-5'>"%>