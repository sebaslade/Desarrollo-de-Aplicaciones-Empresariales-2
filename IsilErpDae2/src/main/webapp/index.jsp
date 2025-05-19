<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Bienvenidos a IsilErpDae2</h1>
		<br>
		<form action="login" method="POST">
			<input type="hidden" name="opcionPost" value="validarUsuario">
			Correo: <input type="text" name="correo"><br><br>
			Contraseña: <input type="password" name="password"><br><br>
			<button>Ingresar</button>
		</form>
	</body>
</html>