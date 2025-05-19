package com.IsilErpDae2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.IsilErpDae2.dao.ProveedorDao;
import com.IsilErpDae2.model.Proveedor;

/**
 * Servlet implementation class ProveedorController
 */
@WebServlet("/proveedor")
public class ProveedorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch(opcion) {
			case "mostrarGestionProveedor":{
				mostrarGestionProveedor(request, response);
				break;
			}
			case "buscarProveedor":{
				try {
					buscarProveedor(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void buscarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String razonSocial = request.getParameter("razonSocial");
		ProveedorDao proveedorDao = new ProveedorDao();
		List<Proveedor> listaProveedores = proveedorDao.buscarProveedor(razonSocial);
		request.setAttribute("listaProveedores", listaProveedores);
		String paginaNueva="/gestionProveedor.jsp";
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}

	private void mostrarGestionProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaNueva="/gestionProveedor.jsp";
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch(opcion) {
			case "mostrarNuevoProveedor":{
				mostrarNuevoProveedor(request,response);
				break;
			}
			case "registrarProveedor":{
				registrarProveedor(request, response);
				break;
			}
		}
	}
	
	
	
	private void registrarProveedor(HttpServletRequest request, HttpServletResponse response) {
		String ruc = request.getParameter("ruc");
		String razonSocial = request.getParameter("razonSocial");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String nombreContacto = request.getParameter("nombreContacto");
		String estado="Activo";//Siempre esta activo, por lo tanto se coloca por defecto
		
	}

	private void mostrarNuevoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaNueva="/nuevoProveedor.jsp";
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}
}
