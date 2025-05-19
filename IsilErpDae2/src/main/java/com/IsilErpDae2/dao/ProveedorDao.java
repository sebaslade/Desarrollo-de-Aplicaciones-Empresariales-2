package com.IsilErpDae2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.IsilErpDae2.model.Proveedor;

public class ProveedorDao {
	private String url;
	private Connection conexion;
	public ProveedorDao(){
		this.url = "jdbc:sqlserver://localhost:1433;databaseName=IsilErpDae2;user=sa;password=sa;encrypt=true;trustServerCertificate=true";
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
	
	public List<Proveedor>buscarProveedor(String razonSocial) throws SQLException{
		List<Proveedor> listaProveedor = new ArrayList<Proveedor>();
		String sentencia = "select * from Proveedor where razonSocial like ?";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentencia);
		pstmt.setString(1, "%"+razonSocial+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			// Aqui voy a sacar cada proveedor que me trajo el query
			int id = rs.getInt(1);
			String ruc = rs.getString(2);
			String razonSocialBD = rs.getString(3);
			String direccion = rs.getString(4);
			String telefono = rs.getString(5);
			String nombreContacto = rs.getString(6);
			String estado = rs.getString(7);
			Proveedor proveedor = new Proveedor();
			proveedor.setId(id);
			proveedor.setRuc(ruc);
			proveedor.setRazonSocial(razonSocialBD);
			proveedor.setDireccion(direccion);
			proveedor.setTelefono(telefono);
			proveedor.setNombreContacto(nombreContacto);
			proveedor.setEstado(estado);
			listaProveedor.add(proveedor);
		}
		rs.close();
		this.conexion.close();
		return listaProveedor;
	}
	
	public void insertarProveedor(String ruc, String razonSocial,String direccion,String telefono, String nombreContacto, String estado) throws SQLException {
		String sentencia = "insert into Proveedor(ruc, razonSocial,direccion,telefono,nombreContacto,estado) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = this.conexion.prepareStatement(sentencia);
		pstmt.setString(1, ruc);
		pstmt.setString(2, razonSocial);
		pstmt.setString(3, direccion);
		pstmt.setString(4, telefono);
		pstmt.setString(5, nombreContacto);
		pstmt.setString(6, estado);
		pstmt.execute();
		this.conexion.close();
	}
}
