package com.IsilERPDae2Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.IsilERPDae2Spring.entity.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "clientes/nuevoCliente";
	}
}
