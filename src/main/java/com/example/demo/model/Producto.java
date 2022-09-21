package com.example.demo.model;

public class Producto {
	private Integer id_producto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	
	public Producto(Integer id_producto, String nombreProducto, String descripcion, Double precio, Integer stock) {
		super();
		this.id_producto = id_producto;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto() {
		super();
	}


	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	

}
