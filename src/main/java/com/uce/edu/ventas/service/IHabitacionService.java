package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;



public interface IHabitacionService {
	public Habitacion buscar(Integer id);
	public void guardar(Habitacion habitacion );
	public void actualizar(Habitacion habitacion );
	public void borrar(Integer id);
	public Hotel buscarDireccion(String direccion);
	public Habitacion buscarPorClase(String clase);
	public List<Habitacion> buscarPorNumero(String numero);
	public List<Habitacion> buscarPorClaseC(String clase,String numero);
	public List<Habitacion> buscarPorClaseIJ(String clase);
	
}
