package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
	public Factura buscar(Integer id);
	public void guardar(Factura factura, Cliente cliente);
	public void actualizar(Factura factura);
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual); 
	public void borrar(Integer id);
	public int borrarPorNumero(String numero);
	public Factura buscarPorNumero(String numero);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaRightJoin();
	public List<Factura> buscarFacturaLeftJoin();
	public List<Factura> buscarFacturaFullJoin();
	public List<Factura> buscarFacturaWhereJoin();
	public List<Factura> buscarFacturaFetchJoin();
	public List<FacturaDTO> buscarFacturasDTO();
}
