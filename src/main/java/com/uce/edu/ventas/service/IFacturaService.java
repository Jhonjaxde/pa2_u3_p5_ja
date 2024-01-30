package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {
	public Factura buscar(Integer id);
	public void guardar(Factura factura);
	public void actualizar(Factura factura);
	public void borrar(Integer id);
	
	public Factura buscarPorNumero(String numero);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaRightJoin();
	public List<Factura> buscarFacturaLeftJoin();
	public List<Factura> buscarFacturaFullJoin();
	public List<Factura> buscarFacturaWhereJoin();
	public List<Factura> buscarFacturaFetchJoin();
}
