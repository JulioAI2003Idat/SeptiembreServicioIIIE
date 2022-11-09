package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "items")
public class Item {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	private String item;
	private Integer cantidad;
	private Double total;
	
	@ManyToOne
	@JoinColumn(
			name="id_cliente",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references clientes(id_cliente)")
			
			)
	private Cliente cliente;

}
