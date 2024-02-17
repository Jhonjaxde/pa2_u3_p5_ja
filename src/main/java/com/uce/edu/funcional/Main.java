package com.uce.edu.funcional;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class Main {

	public static void main(String[] args) {
		//1.- Supplier
		System.out.println("****************SUPPLIER");
		// clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getdId());
		// lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1720368248";
			cedula =  cedula+"canton";
			return cedula;};
		System.out.println(supplierLambda.getdId());
		
		IPersonaSupplier<String> supplierLambda2 = () ->
			"1720368248"+"pais";
			
		System.out.println(supplierLambda2.getdId());
		
		
		IPersonaSupplier<Integer> supplierLambda3 = () ->
		{Integer valor1 = Integer.valueOf(100); 
		valor1 = valor1*Integer.valueOf(50)/Integer.valueOf(5);
		return valor1;};
		System.out.println(supplierLambda3.getdId());
		//2.-Consumer
		System.out.println("****************CONSUMER");
		//Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("profesor");
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> 
		{	System.out.println("Se inserta");
			System.out.println(cadena);};
			consumerLambda.accept("profesor");
		System.out.println("****************PREDICATE");
		//Clases
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero ->
			numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		IPersonaPredicate<String> predicateLambda1 = letra->"Jhon".contains(letra); 
		System.out.println(predicateLambda1.evaluar("e"));
	}

	
	
}
