package com.example.Productos.servicio;

import com.example.Productos.dto.ClienteRegistroDTO;
import com.example.Productos.entidades.Cliente;

public interface ClienteServicioDTO {

    public Cliente guardar(ClienteRegistroDTO registroDTO);

}
