package com.uce.edu.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getdId() {
		// TODO Auto-generated method stub
		String cedula = "1720368248";
		cedula = "provincia"+cedula;
		return cedula;
	}

}
