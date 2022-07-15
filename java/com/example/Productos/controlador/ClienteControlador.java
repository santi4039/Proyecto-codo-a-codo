package com.example.Productos.controlador;


import com.example.Productos.entidades.Cliente;
import com.example.Productos.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @RequestMapping("/clientes")
    public String verPaginaDeClientes(Model modelo){
        List<Cliente> listaClientes = clienteServicio.listAll();

        modelo.addAttribute("listaClientes",listaClientes);
        return "clientes.html";
    }

    @RequestMapping("/nuevoCliente")
    public String mostrarFormularioRegistroClientes(Model modelo){

        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente",cliente);
        return "nuevo_cliente.html";
    }

    @RequestMapping(value = "/guardar_cliente", method = RequestMethod.POST)
    public String guardarCliente(@Validated @ModelAttribute("cliente") Cliente cliente,BindingResult binding, RedirectAttributes redirect, Model modelo){

        if(binding.hasErrors()){
            modelo.addAttribute("cliente",cliente);
            return "nuevo_cliente.html";
        }

        clienteServicio.save(cliente);
        redirect.addFlashAttribute("msgExito","El cliente ha sido guardado con exito");
        return "redirect:/clientes";
    }

    @RequestMapping("/editar_cliente/{id}")
    public ModelAndView mostrarFormularioEditarCliente(@PathVariable(name = "id") Long id){
        ModelAndView modelo = new ModelAndView("editar_cliente");

        Cliente cliente = clienteServicio.get(id);
        modelo.addObject("cliente",cliente);

        return modelo;
    }

    @RequestMapping("/eliminar_cliente/{id}")
    public String eliminarProducto(@PathVariable(name = "id") Long id){
        clienteServicio.delete(id);
        return "redirect:/clientes";
    }



}
