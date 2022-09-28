package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="clientes")
public class Cliente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String cliente;
	private Integer celular;
	
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Producto> productos = new ArrayList<>();
	
	@OneToMany(mappedBy = "")
	private List<Item> items = new ArrayList<>();
	
}