package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHabitacionService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5JaApplication implements CommandLineRunner {
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for (int i = 0; i < 500; i++) {
			Cliente cliente = new Cliente();
			cliente.setNombre("CN" + i);
			cliente.setApellido("CA" + i);
			this.clienteService.guardar(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido= (tiempoFinal-tiempoInicial);
		System.out.println("Tiempo transcurrido en segundos: "+tiempoTranscurrido);
		System.out.println("Se ha mandado a procesar sus 500 clientes, puede continuar con sus actividades");
		//Tiempo transcurrido en seg: 100
		
		
		//programacion en paralelo (multihilo-Multithread)
//		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for (int i = 0; i < 100; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaCliente.add(cliente);
//			
//		}
//		listaCliente.stream().forEach(Cliente->this.clienteService.guardar(Cliente));
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
//		System.out.println("Tiempo transcurrido en segundos: "+tiempoTranscurrido);
//		Tiempo transcurrido en seg: 101
//		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setNombre("CN" + i);
//			cliente.setApellido("CA" + i);
//			listaCliente.add(cliente);
//			
//		}
//		listaCliente.parallelStream().forEach(Cliente->this.clienteService.guardar(Cliente));
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido= (tiempoFinal-tiempoInicial)/1000;
//		System.out.println("Tiempo transcurrido en segundos: "+tiempoTranscurrido);
		
		
		
		
		
		}

}
