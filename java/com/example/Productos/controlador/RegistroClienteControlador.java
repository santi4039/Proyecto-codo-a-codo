package com.example.Productos.controlador;

import com.example.Productos.dto.ClienteRegistroDTO;
import com.example.Productos.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @ModelAttribute("cliente")
    public ClienteRegistroDTO retornarNuevoClienteRegistroDTO(){
        return new ClienteRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("cliente") ClienteRegistroDTO registroDTO){
        clienteServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

}
