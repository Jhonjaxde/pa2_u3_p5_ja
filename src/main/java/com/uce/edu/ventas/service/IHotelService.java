package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;



public interface IHotelService {
	public Hotel buscar(Integer id);
	public void guardar(Hotel hotel );
	public void actualizar(Hotel hotel );
	public void borrar(Integer id);
	public List<Habitacion> buscarPorClase(String clase);
	public Hotel buscarPorNombre(String nombre);
	public Hotel buscarPorDireccion(String direccion);
	public List<Hotel> buscarHabitaciones(String numero);
	public List<Hotel> buscarPorNombreLJ(String nombre);
	public List<Hotel> buscarHabitacionesPorNombreYClase(String numero, String clase);
}
