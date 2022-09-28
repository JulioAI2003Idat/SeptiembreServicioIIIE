package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	
	@RequestMapping(path= "", method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		List<Producto> listaproductos = service.listar();
		return new ResponseEntity<>(listaproductos,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Producto producto = service.obtener(id);
		if (producto!= null) {
			return new ResponseEntity<>(producto,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(producto,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("")
	public ResponseEntity<?> registrar(@RequestBody Producto producto){
		service.guardar(producto);
		return new ResponseEntity<>(producto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Producto p,@PathVariable Integer id){
		//producto.setId_producto(id);

		Producto producto = service.obtener(p.getId_producto());
		if (producto!= null) {
			service.actualizar(producto);
			return new ResponseEntity<>(producto,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(producto,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Producto producto = service.obtener(id);
		if (producto!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
