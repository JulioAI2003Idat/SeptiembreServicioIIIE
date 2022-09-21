package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;

@Repository
public class ProductorepositoryImpl implements ProductoRepository {

	Producto p = new Producto();
	List<Producto> almacenamiento = new ArrayList<>();

	@Override
	public void guardar(Producto producto) {
		almacenamiento.add(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		Producto existeActualizar = obtener(producto.getId_producto());
		eliminar(existeActualizar.getId_producto());
		almacenamiento.add(producto);

	}

	@Override
	public void eliminar(Integer id) {
		Producto existeEliminar = obtener(id);
		almacenamiento.remove(existeEliminar);

	}

	@Override
	public List<Producto> listar() {

		return almacenamiento;
	}

	@Override
	public Producto obtener(Integer id) {
		/*for (Producto producto : almacenamiento) {
			if (producto.getId_producto() == id) {
				return producto;
			}

		}
		return null;
		
	}*/
	return almacenamiento.stream().filter(p->p.getId_producto()==id).findFirst().orElse(null);

}
	}
