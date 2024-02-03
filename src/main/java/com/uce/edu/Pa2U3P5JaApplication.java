package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHabitacionService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5JaApplication implements CommandLineRunner {
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Factura fac = new Factura();
		fac.setCedula("222");
		fac.setFecha(LocalDateTime.now());
		fac.setNumero("001-002");
		
		
		Cliente clie = new Cliente();
		clie.setApellido("Botieso");
		clie.setNombre("Mina");
		this.facturaService.guardar(fac,clie);
	}

}
