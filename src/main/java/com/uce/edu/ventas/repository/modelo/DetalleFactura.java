package com.uce.edu.ventas.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_factura")
	@SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura", allocationSize = 1)
	@Column(name = "defa_id")
	private Integer id;
	@Column(name = "defa_cantidad")
	private Integer cantidad;
	@Column(name = "defa_codigobarras")
	private String codigobarras;
	@Column(name = "defa_nombreProducto")
	private String nombreProducto;
	
	@ManyToOne
	@JoinColumn(name = "defa_id_factura")
	private Factura factura;
	
	//SET AND GET
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getCodigobarras() {
		return codigobarras;
	}
	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", codigobarras=" + codigobarras
				+ ", nombreProducto=" + nombreProducto +  "]";
	}
	
	
	
}
