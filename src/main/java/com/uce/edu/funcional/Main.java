package com.uce.edu.funcional;

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
			}
			;
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

	}

}
