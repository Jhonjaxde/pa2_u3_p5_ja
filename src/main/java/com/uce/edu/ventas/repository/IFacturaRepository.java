package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
	public Factura seleccionar(Integer id);
	public void insertar(Factura factura);
	public void actualizar(Factura factura);
	public int actualizarFechas(LocalDateTime fechaNueva ,LocalDateTime fechaActual);
	public void eliminar(Integer id);
	public int eliminarPorNumero(String numero);
	
	public Factura seleccionarPorNumero(String numero);
	
	public List<Factura> seleccionarInnerJoin();
	public List<Factura> seleccionarRightJoin();
	public List<Factura> seleccionarLeftJoin();
	public List<Factura> seleccionarFullJoin();
	public List<Factura> seleccionarFactura(String numero);
	public List<Factura> seleccionarFacturaWhereJoin();
	public List<Factura> seleccionarFacturaFetchJoin();
	public List<FacturaDTO> seleccionarFacturasDTO();
	public List<Factura> seleccionarTodos();
}
