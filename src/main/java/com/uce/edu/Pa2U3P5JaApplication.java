package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		System.out.println("UPDATE");
		int cantidad=this.facturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50),LocalDateTime.of(2020, 1, 9, 12, 50) );
		System.out.println("cantidad de registros actualizados: "+cantidad);
		
		System.out.println("DELETE");
		int cantidad1 = this.facturaService.borrarPorNumero("0001-04343");
		System.out.println("cantidad de registros borrados: "+cantidad1);
		
		
		//this.facturaService.borrar(1);
		List<FacturaDTO> reporte=this.facturaService.buscarFacturasDTO();
			for (FacturaDTO facturaDTO : reporte) {
				System.out.println(facturaDTO);
			}
		
	}

}
