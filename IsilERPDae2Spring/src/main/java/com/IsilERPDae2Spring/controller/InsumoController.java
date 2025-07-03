package com.IsilERPDae2Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IsilERPDae2Spring.entity.Insumo;
import com.IsilERPDae2Spring.entity.Proveedor;
import com.IsilERPDae2Spring.repository.InsumoRepository;
import com.IsilERPDae2Spring.repository.ProveedorRepository;

@RequestMapping("/insumo")
@Controller
public class InsumoController {
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@Autowired
	InsumoRepository insumoRepository;
	
	@PostMapping("/nuevo")
	public String nuevo(Model model) {
		List<Proveedor> listaProveedores = proveedorRepository.findByEstado("Activo");
		model.addAttribute("listaProveedores", listaProveedores);
		Insumo insumo = new Insumo();
		model.addAttribute("insumo", insumo);
		return "nuevoInsumo";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("insumo")Insumo insumo, Model model) {
		insumo.setEstado("Activo");
		insumoRepository.save(insumo);
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		return "redirect:/home/gestionInsumos";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id")int id, Model model) {
		insumoRepository.deleteById(id);
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		return "redirect:/home/gestionInsumos";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id")int id, Model model) {
		Insumo insumo = insumoRepository.findById(id);
		model.addAttribute("insumo", insumo);
		List<Proveedor> listaProveedores = proveedorRepository.findByEstado("Activo");
		model.addAttribute("listaProveedores", listaProveedores);
		return "editarInsumo";
	}
	
	@RequestMapping(value="/actualizar", method=RequestMethod.POST, params = "grabar")
	public String actualizar(@ModelAttribute("insumo")Insumo insumo, Model model) {
		Insumo insumoBD = insumoRepository.findById(insumo.getId());
		insumoBD.setCategoria(insumo.getCategoria());
		insumoBD.setEstado(insumo.getEstado());
		insumoBD.setNombre(insumo.getNombre());
		insumoBD.setProveedor(insumo.getProveedor());
		insumoBD.setStock(insumo.getStock());
		insumoBD.setStockMinimo(insumo.getStockMinimo());
		insumoRepository.save(insumoBD);
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		return "redirect:/home/gestionInsumos";
	}
	
	@RequestMapping(value="/actualizar", method=RequestMethod.POST, params = "cancelar")
	public String cancelar(@ModelAttribute("insumo")Insumo insumo, Model model) {
		List<Insumo> listaInsumos = insumoRepository.findAll();
		model.addAttribute("listaInsumos", listaInsumos);
		return "gestionInsumos";
	}
}
