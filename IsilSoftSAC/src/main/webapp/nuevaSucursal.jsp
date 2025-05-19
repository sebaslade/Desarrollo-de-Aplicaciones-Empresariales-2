<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Gestión Sucursal</title>
	</head>
	<body>
		<form action="sucursal" method="POST">
			<h1>Nueva Sucursal</h1>
			<input type="hidden" name="opcionPost" value="registrarSucursal">
			Nombre:<input type="text" name="nombre"><br><br>
			Direccion: <input type="text" name="direccion"><br><br>
			<button type="submit">Guardar</button>
		</form>
	</body>
</html>