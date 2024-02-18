package com.uce.edu.funcional;

public class MetodosReferenciados {
	public String obtenerId() {
		// TODO Auto-generated method stub
		String cedula = "1720368248";
		cedula = cedula+"referenciados";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("se proceso la cadena");
		
	}
	public boolean evaluar(String cadena) {
		// TODO Auto-generated method stub
		return "JHON".toLowerCase().contains(cadena);
	}
	
	public boolean evaluar(Integer numero) {
		// TODO Auto-generated method stub
		return 8==numero;
	}
	public Ciudadano cambiar(Empleado emp) {
		Ciudadano ciu = new Ciudadano();
		String nombre= emp.getNombreCompleto().split(" ")[0];
		String apellido = emp.getNombreCompleto().split(" ")[1];
		ciu.setNombre(nombre);
		ciu.setApellido(apellido);
		ciu.setProvincia("tulcan");
		return ciu;
	
	}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+" "+empl.getPais());
		empl.setPais(empl.getPais()+" "+"de nacimiento");
		return empl;
		
	}
	
}