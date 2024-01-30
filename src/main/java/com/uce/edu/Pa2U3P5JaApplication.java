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

		System.out.println("INNER JOIN");
		List<Factura> reporte1 = this.facturaService.buscarFacturaInnerJoin();
		for (Factura f : reporte1) {
			System.out.println(f.getNumero());
//			for (DetalleFactura defa : f.getDetalles()) {
//				System.out.println(defa.getNombreProducto());
//			}

		}

		System.out.println("WHERE JOIN");
		List<Factura> reporte = this.facturaService.buscarFacturaWhereJoin();
		for (Factura f : reporte) {
			System.out.println(f.getNumero());
			for (DetalleFactura defa : f.getDetalles()) {
				System.out.println(defa.getNombreProducto());
			}

		}
		System.out.println("FETCH JOIN");
		List<Factura> reporte2 = this.facturaService.buscarFacturaFetchJoin();
		for (Factura f : reporte2) {
			System.out.println(f.getNumero());
			for (DetalleFactura defa : f.getDetalles()) {
				System.out.println(defa.getNombreProducto());
			}

		}

	}

}
