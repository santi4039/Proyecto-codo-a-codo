package com.example.Productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Productos.entidades.Producto;
import com.example.Productos.servicio.ProductoServicio;



@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoServicio;

	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo,@Param("palabraClave") String palabraClave) {
		List<Producto> listaProductos = productoServicio.listAll(palabraClave);

		modelo.addAttribute("listaProductos",listaProductos);
		modelo.addAttribute("palabraClave",palabraClave);
		
		return "index";
	}


	@RequestMapping("/mercados")
	public String verMercado(){
		return "mercados.html";
	}


	@RequestMapping("/nuevo")
	public String mostrarFormularioRegistro(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("producto",producto);
		return "nuevo_producto";
	}

	@RequestMapping(value = "/guardar",method = RequestMethod.POST)
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		productoServicio.save(producto);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarFormularioEditar(@PathVariable(name = "id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_producto");
		
		Producto producto = productoServicio.get(id);
		modelo.addObject("producto",producto);
		
		return modelo;
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable(name = "id") Long id) {
		productoServicio.delete(id);
		return "redirect:/";
	}

}
