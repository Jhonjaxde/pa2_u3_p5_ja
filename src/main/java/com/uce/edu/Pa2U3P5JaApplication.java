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

		Hotel ho = new Hotel();
		ho.setNombre("El Vergel Norte");
		ho.setDireccion("Calle El Vergel, y, Quito");
		
		Habitacion ha1 = new Habitacion();
		ha1.setClase("premium");
		ha1.setNumero("22");
		Habitacion ha2 = new Habitacion();
		ha2.setClase("premium");
		ha2.setNumero("33");
		Habitacion ha3 = new Habitacion();
		ha3.setClase("estandar");
		ha3.setNumero("01");
		//Relaciones
		
		List<Habitacion> listaHa = new ArrayList<>();
		listaHa.add(ha1);
		listaHa.add(ha2);
		//listaHa.add(ha3);
		ho.setHabitaciones(listaHa);
		ha1.setHotel(ho);
		ha2.setHotel(ho);
		//ha3.setHotel(ho);
		
		//this.hotelService.guardar(ho);
		System.out.println("FULL JOIN");
		List<Hotel> reporte = this.hotelService.buscarHabitacionesPorNombreYClase("33","premium");
		for (Hotel hotel : reporte) {
			System.out.println(hotel.getNombre());
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				System.out.println(habitacion);
			}
			
		}
		
		
		
		
		
		}

}
