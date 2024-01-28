package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHabitacionRepository;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;


@Service
public class HabitacionServiceImpl implements IHabitacionService {
	@Autowired
	private IHabitacionRepository habitacionRepository;
	@Override
	public Habitacion buscar(Integer id) {
		
		return this.habitacionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		this.habitacionRepository.insertar(habitacion);

	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.habitacionRepository.actualizar(habitacion);

	}

	@Override
	public void borrar(Integer id) {
		this.habitacionRepository.eliminar(id);

	}

	@Override
	public Hotel buscarDireccion(String direccion) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarDireccion(direccion);
	}

	@Override
	public Habitacion buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorClase(clase);
	}

	@Override
	public List<Habitacion> buscarPorNumero(String numero) {
		
		return this.habitacionRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<Habitacion> buscarPorClaseC(String clase, String numero) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorClaseC(clase, numero);
	}

	@Override
	public List<Habitacion> buscarPorClaseIJ(String clase) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorClaseIJ(clase);
	}

}
