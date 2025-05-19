package com.IsilSoftSAC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.IsilSoftSAC.model.Sucursal;

public class SucursalDao {
	private String url;
	private Connection conexion;
	public SucursalDao() {
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=Sucursales;user=sa;password=sa;encrypt=true;trustServerCertificate=true";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(this.url);
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
	
	public List<Sucursal>buscarSucursal(String nombre) throws SQLException{
		List<Sucursal> listaSucursal = new ArrayList<Sucursal>();
		String sentencia = "select * from Sucursal where nombre like ?";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentencia);
		pstmt.setString(1, "%"+nombre+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int codigo = rs.getInt(1);
			String nombreSucursal = rs.getString(2);
			String direccion = rs.getString(3);
			String estado = rs.getString(4);
			Sucursal sucursal = new Sucursal();
			sucursal.setCodigo(codigo);	
			sucursal.setNombre(nombreSucursal);
			sucursal.setDireccion(direccion);
			sucursal.setEstado(estado);
			listaSucursal.add(sucursal);
		}
		rs.close();
		this.conexion.close();
		return listaSucursal;
	}
	
	public void insertarSucursal(String nombre, String direccion, String estado) throws SQLException {
		String sentencia = "insert into Sucursal(nombre, direccion, estado) values(?,?,?)";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentencia);
		pstmt.setString(1, nombre);
		pstmt.setString(2, direccion);
		pstmt.setString(3, estado);
		pstmt.execute();
		this.conexion.close();
	}

}
