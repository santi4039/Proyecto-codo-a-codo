package com.example.Productos.repositorio;

import com.example.Productos.entidades.Cliente;
import com.example.Productos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
