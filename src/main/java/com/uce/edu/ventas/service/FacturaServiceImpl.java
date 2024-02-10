package com.uce.edu.ventas.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class FacturaServiceImpl implements IFacturaService {
	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IClienteService clienteService;
	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Factura factura,Cliente cliente) {
		BigDecimal valor= new BigDecimal(100);
		valor.multiply(new BigDecimal(0.2));
		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.facturaRepository.insertar(factura);
		System.out.println("paso el insert de factura");
		this.clienteService.guardar(cliente);
		System.out.println("paso el insert de cliente");
	}
//	begin
//	insert factura(ok)
//	insert cliente(error)
//	rollback
//	
//	
//	
//	
//	
//	
	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.actualizar(factura);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.facturaRepository.eliminar(id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarRightJoin();
	}

	@Override
	public List<Factura> buscarFacturaLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaFullJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFullJoin();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturaWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturaFetchJoin();
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.facturaRepository.actualizarFechas(fechaNueva, fechaActual);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarFacturasDTO();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba() {
		System.out.println("Este metodo  es de prueba");
		System.out.println("Prueba: "+TransactionSynchronizationManager.isActualTransactionActive());
		
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionarTodos();
	}

	@Override
	//@Transactional(value = TxType.REQUIRED)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		//System.out.println("Es un metodo supports");
		System.out.println("Prueba Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaSupports();

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Prueba Factura: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.clienteService.pruebaNever();
	}

}
