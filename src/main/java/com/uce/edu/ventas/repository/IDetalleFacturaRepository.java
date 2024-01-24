package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;


public interface IDetalleFacturaRepository {
	public DetalleFactura seleccionar(Integer id);
	public void insertar(DetalleFactura detalleFactura);
	public void actualizar(DetalleFactura detalleFactura);
	public void eliminar(Integer id);
}
