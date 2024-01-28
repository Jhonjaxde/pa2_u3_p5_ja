package com.uce.edu.ventas.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_habitacion")
	@SequenceGenerator(name= "seq_habitacion",sequenceName = "seq_habitacion",allocationSize = 1)
	@Column(name = "hab_id")
	private Integer id;
	@Column(name = "hab_numero")
	private String numero;
	@Column(name = "hab_clase")
	private String clase;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hab_id_hot")
	private Hotel hotel;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", clase=" + clase +  "]";
	}
	
	
}
