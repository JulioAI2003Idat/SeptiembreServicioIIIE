package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="productos")
public class Producto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	private String nombreProducto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@OneToOne
	private Proveedor proveedor;
	
	@ManyToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="producto_cliente",
			joinColumns = @JoinColumn(
					name = "id_producto",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references producto(id_producto)")
					),
			inverseJoinColumns = @JoinColumn(
					name = "id_cliente",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes(id_cliente)")
					)
			)
	private List<Cliente> cliente = new ArrayList<>();
	

}