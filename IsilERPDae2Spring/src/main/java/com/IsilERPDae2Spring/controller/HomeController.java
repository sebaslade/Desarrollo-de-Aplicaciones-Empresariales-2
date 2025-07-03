package com.IsilERPDae2Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.IsilERPDae2Spring.entity.Cliente;
import com.IsilERPDae2Spring.entity.Insumo;
import com.IsilERPDae2Spring.repository.ClienteRepository;
import com.IsilERPDae2Spring.repository.InsumoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	InsumoRepository insumoRepository;

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/gestionInsumos")
	public String gestionInsumos(Model model) {
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		return "gestionInsumos";
	}
	
	@GetMapping("/gestionClientes")
	public String gestionClientes(Model model) {
		List<Cliente> listaClientes = clienteRepository.findAll();
		model.addAttribute("listaClientes", listaClientes);
		return "clientes/gestionClientes";
	}
}
