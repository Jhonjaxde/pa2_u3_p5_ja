package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class Main {

	public static void main(String[] args) {
		// 1.- Supplier
		System.out.println("****************SUPPLIER");
		// clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getdId());
		// lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "1720368248";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getdId());

		IPersonaSupplier<String> supplierLambda2 = () -> "1720368248" + "pais";

		System.out.println(supplierLambda2.getdId());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getdId());
		// Metodos referenciados
		System.out.println("Metodos referenciados");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getdId());

		// 2.-Consumer
		System.out.println("****************CONSUMER");
		// Clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("profesor");
		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("profesor");

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Edison Referenciado");

		// 3.-Predicate
		System.out.println("****************PREDICATE");
		// lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

		IPersonaPredicate<String> predicateLambda1 = letra -> "Jhon".contains(letra);
		System.out.println(predicateLambda1.evaluar("e"));

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaPredicate<String> predicate1 = met::evaluar;
		System.out.println(predicate1.evaluar("o"));
		IPersonaPredicate<Integer> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar(8));
		// 4.-Function
		System.out.println("****************FUNCTION");
		// lambdas
		System.out.println("Lambdas");
		IPersonaFunction<String, Integer> functionlambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-valor");
			return numeroString;
		};
		System.out.println(functionlambda.aplicar(7));

		IPersonaFunction<Empleado, Ciudadano> functionlambda1 = ciudadano -> {
			Empleado emp = new Empleado();
			emp.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
				emp.setPais("Ecuador");
			};
			return emp;
		};
		Ciudadano ciu = new Ciudadano();
		ciu.setNombre("JHON");
		ciu.setApellido("ARTEAGA");
		ciu.setProvincia("pichincha");
		System.out.println(functionlambda1.aplicar(ciu));
		// Metodos referenciados
		System.out.println("Metodos referenciados");
		Empleado emp = new Empleado();
		emp.setNombreCompleto("Daniel Noboa");
		emp.setPais("pifo York");
		IPersonaFunction<Ciudadano, Empleado> function = met::cambiar;
		System.out.println(function.aplicar(emp));
		// 4.-Unary Operator
		System.out.println("****************UNARY OPERATOR");
		// lambdas
		System.out.println("Lambdas");
		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda.aplicar(14));
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda1 = numero -> numero + (numero * 2);
		System.out.println(unaryOperatorLambda1.aplicar(10));

		// Metodos referenciados
		System.out.println("Metodos referenciados");
		IPersonaUnaryOperator<Empleado> unaryOperator1 = met::procesar;
		System.out.println(unaryOperator1.aplicar(emp));
		System.out.println("****************Implementacion de interfaces funcionales mediante stream");
		// 1. supplier
		Stream<String> lista = Stream.generate(() -> "17298" + " pais").limit(20);
		lista.forEach(cadena -> System.out.println(cadena));
		// 2.- Consumer
		System.out.println("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 67, 8, 5, 4, 85, 74);
		listaNumeros.forEach(numero -> {
			System.out.println("se inserta");
			System.out.println(numero);

		});

		// 3. Predicate
		System.out.println("Predicate JAVA");
		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> {
			return numero >= 10;
		});
		listaFiltrada.forEach(numero -> System.out.println(numero));
		// 4. function
		System.out.println("Function JAVA");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return "Num: " + numero.toString();
		});
		
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("JHON");
		ciu1.setApellido("ARTEAGA");
		ciu1.setProvincia("pichincha");
		
		Ciudadano ciu2 = new Ciudadano();
		ciu2.setNombre("JAIRO");
		ciu2.setApellido("CHILES");
		ciu2.setProvincia("pichincha");
		
		Ciudadano ciu3 = new Ciudadano();
		ciu3.setNombre("NELLY");
		ciu3.setApellido("CHILES");
		ciu3.setProvincia("pichincha");
		
		List<Ciudadano> listaCiudadano = Arrays.asList(ciu1,ciu2,ciu3);
		listaCiudadano.stream().map(ciudadano->{
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if (ciudadano.getProvincia().compareTo("pichincha") == 0) {
				empl.setPais("Ecuador");
			};
			return empl;	
		}).forEach(empl -> System.out.println(empl));
		// 5. Unary Operator
		System.out.println("Unary Operator JAVA");
		Stream<Integer> listaNumeros2 = listaNumeros.stream().map(numero -> {
			numero = numero * 100 / 50;
			return numero;
		});
		
		listaNumeros2.forEach(numero -> System.out.println(numero));
		
	}

}
