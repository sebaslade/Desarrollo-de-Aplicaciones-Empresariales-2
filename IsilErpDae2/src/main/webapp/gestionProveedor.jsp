<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión Proveedor</title>
	</head>
	<body>
		<h1>Gestión Proveedor</h1>
		<br>
		<br>
		<br>
		<form action="proveedor" method="GET">
			<input type="hidden" name="opcionGet" value="buscarProveedor">
			Razón Social: <input type="text" name="razonSocial">
			<button>Buscar</button><br><br>
		</form>
		<h3>Resultado de Búsqueda</h3>
		<br>
		<table>
			<tr>
				<td>Código</td>
				<td>Ruc</td>
				<td>Razón Social</td>
				<td>Estado</td>
				<td>Acciones</td>
			</tr>
			<c:forEach var="proveedor" items="${listaProveedores}">
				<tr>
					<td>${proveedor.id}</td>
					<td>${proveedor.ruc}</td>
					<td>${proveedor.razonSocial}</td>
					<td>${proveedor.estado}</td>
					<td>Editar Eliminar</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="proveedor" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoProveedor">
			<button>Nuevo</button>
		</form>
		
	</body>
</html>