package com.example.Productos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Productos.entidades.Producto;


public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1%"
			+ " OR p.marca LIKE %?1%"
			+ " OR p.hechoEn LIKE %?1%")

	public List<Producto> findAll(String palabraClave);
}
