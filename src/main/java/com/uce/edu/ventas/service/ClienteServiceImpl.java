package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private IClienteRepository clienteRepository;
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		
		try {
		this.clienteRepository.insertar(cliente);
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
		
		
	}
	@Transactional(value = TxType.SUPPORTS)
	@Override
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Es un metodo supports");
		System.out.println("Prueba supports: "+TransactionSynchronizationManager.isActualTransactionActive());
		

	}
	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Es un metodo never");
		System.out.println("Prueba never: "+TransactionSynchronizationManager.isActualTransactionActive());
		
	}

}
