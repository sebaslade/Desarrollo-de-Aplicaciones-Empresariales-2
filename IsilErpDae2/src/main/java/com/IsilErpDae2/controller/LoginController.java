package com.IsilErpDae2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.IsilErpDae2.dao.UsuarioDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login") //asignando ALIAS
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch(opcion) {
			case"validarUsuario":{
				try {
					validarUsuario(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String paginaNueva;
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		UsuarioDao usuarioDao = new UsuarioDao();
		boolean existe= usuarioDao.validarUsuario(correo, password);
		if(existe) {
			// Lo dejamos entrar
			paginaNueva = "/principal.jsp";
		}
		else {
			// No lo dejamos entrar
			paginaNueva = "/index.jsp";
		}
		// Redireccionando a otra pagina
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaNueva);
		dispatcher.forward(request, response);
	}
}
