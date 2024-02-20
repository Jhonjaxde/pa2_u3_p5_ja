package com.uce.edu.ventas.service;

import java.util.concurrent.TimeUnit;

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
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		
		try {
			this.clienteRepository.insertar(cliente);
			// duermete un segundo
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e) {
			System.out.println(e.getClass());
		}

	}

	@Transactional(value = TxType.SUPPORTS)
	@Override
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("Es un metodo supports");
		System.out.println("Prueba supports: " + TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("Es un metodo never");
		System.out.println("Prueba never: " + TransactionSynchronizationManager.isActualTransactionActive());

	}

}
