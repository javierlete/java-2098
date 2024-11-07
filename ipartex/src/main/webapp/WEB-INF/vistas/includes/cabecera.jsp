<%@page import="ipartex.modelos.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Ipartex</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/bootstrap-icons.min.css">
<link rel="stylesheet" href="css/dataTables.bootstrap5.css">

<link rel="icon" href="icons/chat-left-quote-fill.svg">

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index"><i
				class="bi bi-chat-left-quote-fill"></i> Ipartex</a>
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
					<li class="nav-item"><a class="nav-link" href="perfil"><%=usuario.getNombre()%></a></li>
					<li class="nav-item"><a class="nav-link" href="logout">Cerrar sesión</a></li>
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link" href="registro">Registro</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Inicio
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<%="<main class='container mt-4 mb-5 pb-5'>"%>