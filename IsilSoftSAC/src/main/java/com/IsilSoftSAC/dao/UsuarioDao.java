package com.IsilSoftSAC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDao {
	private String url;
	private Connection conexion;
	
	public UsuarioDao() {
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=Sucursales;user=sa;password=sa;encrypt=true;trustServerCertificate=true";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(this.url);
			if (this.conexion == null) {
				System.err.println("No se pudo establecer la conexión con la base de datos.");
			}
		}
		catch(ClassNotFoundException e) {
			// TODO auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validarUsuario(String correo, String password) throws SQLException{
		boolean existeUsuario = false;
		String sentencia = "Select * from Usuario where correo = '" + correo + "' and password='" + password +"'";
		Statement stmt = this.conexion.createStatement();
		ResultSet rs = stmt.executeQuery(sentencia);
		while(rs.next()) {
			existeUsuario = true;
		}
		rs.close();
		this.conexion.close();
		return existeUsuario;
	}
}
