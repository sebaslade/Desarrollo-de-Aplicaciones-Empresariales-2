package com.IsilERPDae2Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.IsilERPDae2Spring.entity.Usuario;
import com.IsilERPDae2Spring.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/validarUsuario", method=RequestMethod.POST)
	public String validarUsuario(@RequestParam("correo")String correo, @RequestParam("password")String password) {
		Usuario usuario = usuarioRepository.findByCorreoAndPassword(correo, password);
		if(usuario==null) {
			return "index";
		}else {
			return "principal";
		}
	}
}
