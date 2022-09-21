package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Producto;

public interface ProductoRepository {
	
	void guardar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id);
	List<Producto> listar();
	Producto obtener(Integer id);
}
