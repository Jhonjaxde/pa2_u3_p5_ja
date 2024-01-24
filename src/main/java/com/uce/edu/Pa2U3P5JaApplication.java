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
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JaApplication implements CommandLineRunner{
	@Autowired
	private IFacturaService facturaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Factura fac = new Factura();
		fac.setNumero("0001-02323");
		fac.setFecha(LocalDateTime.now());
		fac.setCedula("1720368248");
		
		DetalleFactura de1 = new DetalleFactura();
		de1.setCantidad(1);
		de1.setCodigobarras("JH23J24");
		de1.setNombreProducto("Coca Cola 3L");
		
		DetalleFactura de2 = new DetalleFactura();
		de2.setCantidad(13);
		de2.setCodigobarras("JH23T33");
		de2.setNombreProducto("Lecha Vita 1L");
		
		List<DetalleFactura> lista = new ArrayList<>();
		lista.add(de1);
		lista.add(de2);
		fac.setDetalles(lista);
		de1.setFactura(fac);
		de2.setFactura(fac);
		
		//this.facturaService.guardar(fac);
		
		
		for (DetalleFactura detalleFactura : fac.getDetalles()) {
			System.out.println(detalleFactura);
		}
		System.out.println(this.facturaService.buscarPorNumero("0001-02323"));
	}
	

}
