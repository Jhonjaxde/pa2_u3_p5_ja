package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
@Service
public class FacturaServiceImpl implements IFacturaService {
	@Autowired
	private IFacturaRepository facturaRepository;
	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.seleccionar(id);
	}

	@Override
	public void guardar(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepository.insertar(factura);
	}

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

}
