package com.IsilSoftSAC.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.IsilSoftSAC.dao.SucursalDao;
import com.IsilSoftSAC.model.Sucursal;



/**
 * Servlet implementation class SucursalController
 */
@WebServlet("/sucursal")
public class SucursalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SucursalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		if (opcion == null) {
	        response.sendRedirect("sucursal?opcionGet=mostrarGestionSucursal");
	        return;
	    }
		switch(opcion) {
			case "mostrarGestionSucursal":{
				mostrarGestionSucursal(request, response);
				break;
			}
			case "buscarSucursal":{
				try {
					buscarSucursal(request,response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default: {
	            response.sendRedirect("sucursal?opcionGet=mostrarGestionSucursal");
	            break;
	        }
		}
	}
	
	private void buscarSucursal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String nombreSucursal = request.getParameter("nombreSucursal");
		SucursalDao sucursalDao = new SucursalDao();
		List<Sucursal> listaSucursales = sucursalDao.buscarSucursal(nombreSucursal);
		request.setAttribute("listaSucursales", listaSucursales);
		String paginaNueva="/gestionSucursal.jsp";
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}

	private void mostrarGestionSucursal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaNueva="/gestionSucursal.jsp";
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
			case "mostrarNuevaSucursal":{
				mostrarNuevaSucursal(request,response);
				break;
			}
			case "registrarSucursal":{
				try {
					registrarSucursal(request, response);
					response.sendRedirect("sucursal?opcionGet=mostrarGestionSucursal");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void registrarSucursal(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String estado="Activo";
		SucursalDao sucursalDao = new SucursalDao();
		sucursalDao.insertarSucursal(nombre, direccion, estado);
	}

	private void mostrarNuevaSucursal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaNueva="/nuevaSucursal.jsp";
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}

}
