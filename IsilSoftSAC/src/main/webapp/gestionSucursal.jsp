<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión Sucursal</title>
	</head>
	<body>
		<h1>Gestión Sucursal</h1>
		<br>
		<br>
		<br>
		<form action="sucursal" method="GET">
			<input type="hidden" name="opcionGet" value="buscarSucursal">
			Nombre: <input type="text" name="nombreSucursal">
			<button>Buscar</button><br><br>
		</form>
		<h3>Resultado de Búsqueda</h3>
		<br>
		<table>
			<tr>
				<td>Código</td>
				<td>Nombre</td>
				<td>Dirección</td>
				<td>Estado</td>
			</tr>
			<c:forEach var="sucursal" items="${listaSucursales}">
				<tr>
					<td>${sucursal.codigo}</td>
					<td>${sucursal.nombre}</td>
					<td>${sucursal.direccion}</td>
					<td>${sucursal.estado}</td>
					<td>Editar Eliminar</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="sucursal" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevaSucursal">
			<button>Agregar</button>
		</form>
		
	</body>
</html>