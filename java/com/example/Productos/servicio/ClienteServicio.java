package com.example.Productos.servicio;

import com.example.Productos.dto.ClienteRegistroDTO;
import com.example.Productos.entidades.Cliente;
import com.example.Productos.entidades.Producto;
import com.example.Productos.entidades.Rol;
import com.example.Productos.repositorio.ClienteRepositorio;
import com.example.Productos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ClienteServicio implements ClienteServicioDTO {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listAll(){

        return clienteRepositorio.findAll();
    }

    public void save(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    public Cliente get(Long id) {
        return clienteRepositorio.findById(id).get();
    }

    public void delete(Long id) {
        clienteRepositorio.deleteById(id);
    }

    @Override
    public Cliente guardar(ClienteRegistroDTO registroDTO) {
        Cliente cliente = new Cliente(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(), registroDTO.getPassword(),
                Arrays.asList(new Rol("ROLE_USER")));

                return clienteRepositorio.save(cliente);
    }
}
