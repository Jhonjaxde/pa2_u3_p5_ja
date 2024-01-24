package com.uce.edu.ventas.repository;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
	public Factura seleccionar(Integer id);
	public void insertar(Factura factura);
	public void actualizar(Factura factura);
	public void eliminar(Integer id);
	
	public Factura seleccionarPorNumero(String numero);
}
