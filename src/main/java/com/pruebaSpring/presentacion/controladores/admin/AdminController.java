package com.pruebaSpring.presentacion.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaSpring.dominio.entidades.Producto;
import com.pruebaSpring.dominio.servicios.AdminServicios;
import com.pruebaSpring.dominio.servicios.ClaveDuplicadaException;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServicios adminServicios;
	
	@GetMapping
	public String productos(Model modelo) {
		modelo.addAttribute("productos", adminServicios.getAllProductos());
		return "admin/index";
	}
	
	@GetMapping("/delete")
	public String borrar(Long id) {
		adminServicios.delete(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/producto")
	public String producto(Model modelo, Long id, Producto producto) {
		if(id != null) {
			modelo.addAttribute("producto", adminServicios.getProductoById(id).get());
		}
		return "admin/producto";
	}
	
	@PostMapping
	public String post(Model modelo, @Valid Producto producto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("alerta", "Revisa los errores en el formulario");
			modelo.addAttribute("nivel", "danger");
			
			return "admin/producto";
		}
		
		try {
			if(producto.getIdProducto() == null) {
				adminServicios.save(producto);
			}else {
				adminServicios.update(producto);
			}
		}catch(ClaveDuplicadaException e) {
			if(e.getCampo() != null) {
				modelo.addAttribute("alerta", "Revisa los errores en el formulario");
				modelo.addAttribute("nivel", "danger");
				
				bindingResult.addError(new FieldError(e.getObjeto(), e.getCampo(), e.getMessage()));
			}else {
				modelo.addAttribute("alerta", e.getMessage());
				modelo.addAttribute("nivel", "danger");
			}
			return  "admin/producto";
		}
		
		return "redirect:/admin";
	}
	
}
