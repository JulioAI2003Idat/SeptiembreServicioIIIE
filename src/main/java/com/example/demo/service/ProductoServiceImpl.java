package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repositorio;
	
	@Override
	public void guardar(Producto producto) {
		repositorio.guardar(producto);
		
	}

	@Override
	public void actualizar(Producto producto) {
		repositorio.actualizar(producto);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
