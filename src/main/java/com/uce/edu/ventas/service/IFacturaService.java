package com.uce.edu.ventas.service;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {
	public Factura buscar(Integer id);
	public void guardar(Factura factura);
	public void actualizar(Factura factura);
	public void borrar(Integer id);
	
	public Factura buscarPorNumero(String numero);
}
