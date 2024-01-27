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
public class Pa2U3P5JaApplication implements CommandLineRunner {
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Factura fac = new Factura();
//		fac.setNumero("0001-04343");
//		fac.setFecha(LocalDateTime.now());
//		fac.setCedula("1720312348");
//
//		DetalleFactura de1 = new DetalleFactura();
//		de1.setCantidad(43);
//		de1.setCodigobarras("JH55M24");
//		de1.setNombreProducto("GALLETA AMOR");
//
//		DetalleFactura de2 = new DetalleFactura();
//		de2.setCantidad(23);
//		de2.setCodigobarras("LL23T33");
//		de2.setNombreProducto("CERVEZA");
//		
//		DetalleFactura de3 = new DetalleFactura();
//		de3.setCantidad(20);
//		de3.setCodigobarras("LL23Y13");
//		de3.setNombreProducto("COMIDA PARA PERRO");
//
//		List<DetalleFactura> lista = new ArrayList<>();
//		lista.add(de1);
//		lista.add(de2);
//		lista.add(de3);
//		fac.setDetalles(lista);
//		de1.setFactura(fac);
//		de2.setFactura(fac);
//		de3.setFactura(fac);
//		this.facturaService.guardar(fac);
//
//		for (DetalleFactura detalleFactura : fac.getDetalles()) {
//			System.out.println(detalleFactura);
//		}
//		System.out.println(this.facturaService.buscarPorNumero("0001-02323"));
		System.out.println("INNER JOIN");
		List<Factura> reporte = this.facturaService.buscarFacturaInnerJoin();
		for (Factura factura : reporte) {
			System.out.println(factura);
		}
		System.out.println("RIGHT JOIN");
		List<Factura> reporte1 = this.facturaService.buscarFacturaRightJoin();
		for (Factura factura : reporte1) {
			System.out.println(factura.getNumero());
		}
		
		System.out.println("LEFT JOIN");
		List<Factura> reporte2 = this.facturaService.buscarFacturaLeftJoin();
		for (Factura factura : reporte2) {
			System.out.println(factura.getNumero());
		}
		
		System.out.println("FULL JOIN");
		List<Factura> reporte3 = this.facturaService.buscarFacturaFullJoin();
		for (Factura f : reporte3) {
			System.out.println(f);
			for(DetalleFactura d :f.getDetalles()) {
				System.out.println(d);
			}
		}
		
	}

}
