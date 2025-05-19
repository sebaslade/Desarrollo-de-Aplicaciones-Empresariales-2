<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form>
			<h1>Nuevo Proveedor</h1>
			<input type="hidden" name="opcionPost" value="registrarProveedor">
			RUC:<input type="text" name="ruc">
			Razon Social:<input type="text" name="razonSocial"><br><br>
			Direccion: <input type="text" name="direccion"><br><br>
			Telefono: <input type="text" name="telefono"><br><br>
			Nombre de contacto: <input type="text" name="nombreContacto"><br><br>
			Estado: <input type="text" name="estado"><br><br>
			<button>Guardar</button>
		</form>
	</body>
</html>