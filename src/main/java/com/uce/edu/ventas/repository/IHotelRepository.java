package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;



public interface IHotelRepository {
	public Hotel seleccionar(Integer id);
	public void insertar(Hotel hotel );
	public void actualizar(Hotel hotel );
	public void eliminar(Integer id);
	public List<Habitacion> seleccionarPorClase(String clase);
	public Hotel seleccionarPorNombre(String nombre);
	public Hotel seleccionarPorDireccion(String direccion);
	public List<Hotel> seleccionarHabitaciones(String numero);
	public List<Hotel> seleccionarPorNombreLJ(String nombre);
	public List<Hotel> seleccionarHabitacionesPorNombreYClase(String numero,String clase);
}
