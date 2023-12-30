package com.pruebaSpring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaSpring.bibliotecas.Alerta;
import com.pruebaSpring.dominio.servicios.UsuarioServicios;

@Controller
@RequestMapping
public class IndexController {
	
	@Autowired
	private UsuarioServicios usuarioServicios;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", usuarioServicios.getAllProductos());
		modelo.addAttribute("categorias", usuarioServicios.getAllCategorias());
		return "index";
	}
	
	@GetMapping("/{id}")
	public String productosByCategoria(Model modelo,@PathVariable Long id) {
		modelo.addAttribute("idCategoria", id);
		modelo.addAttribute("categorias", usuarioServicios.getAllCategorias());
		modelo.addAttribute("productos", usuarioServicios.getProductoByCategoria(id));
		return "indexPorCategorias";
	}
	
	@GetMapping("/producto/{id}")
	public String producto(Model modelo, @PathVariable Long id) {
		modelo.addAttribute("producto", usuarioServicios.getProductoById(id).get());
		return "producto";
	}
	
	@GetMapping("/login")
	public String login(String error, String logout, String noautorizado, String interactivo, Model modelo) {
		Alerta alerta = new Alerta(modelo);

		if (error != null) {
			alerta.danger("El usuario o la contraseña no son correctos");
		} else if (logout != null) {
			alerta.success("Se ha desconectado de la sesión correctamente");
		} else if(noautorizado != null) {
			alerta.danger("Tu nivel de acceso no es suficiente");
		} else if(interactivo != null) {
		} else {
			alerta.warning("Tienes que iniciar sesión");
		}

		return "login";
	}
}
