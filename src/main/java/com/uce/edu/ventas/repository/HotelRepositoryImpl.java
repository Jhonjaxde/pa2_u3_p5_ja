package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public List<Habitacion> seleccionarPorClase(String clase) {
		TypedQuery<Habitacion> consulta = this.entityManager
				.createQuery("SELECT ho FROM Hotel ho WHERE ho.habitaciones.clase=:clase ", Habitacion.class);
		consulta.setParameter("clase", clase);
		return consulta.getResultList();
	}

	@Override
	public Hotel seleccionarPorNombre(String nombre) {
		Query consulta = this.entityManager.createNativeQuery("SELECT * FROM hotel ho WHERE ho.hot_nombre=:nombre",
				Hotel.class);
		consulta.setParameter("nombre", nombre);
		return (Hotel) consulta.getSingleResult();
	}

	@Override
	public Hotel seleccionarPorDireccion(String direccion) {
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Hotel> myCriteriaQuery = myCriteria.createQuery(Hotel.class);
		Root<Hotel> myFrom = myCriteriaQuery.from(Hotel.class);
		Predicate condicionDireccion = myCriteria.equal(myFrom.get("direccion"), direccion);
		myCriteriaQuery.select(myFrom).where(condicionDireccion);
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Hotel> seleccionarHabitaciones(String numero) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT ho FROM Hotel ho RIGHT JOIN ho.habitaciones ha WHERE ha.numero=:numero",
				Hotel.class);
		//myQuery= this.entityManager.createQuery("SELECT ho FROM Hotel ho WHERE ho.habitaciones.numero=:numero", Hotel.class);
		myQuery.setParameter("numero", numero);
		List<Hotel> listaHa = myQuery.getResultList();
		for (Hotel hotel : listaHa) {
			hotel.getHabitaciones().size();
		}

		return listaHa;
	}

	@Override
	public List<Hotel> seleccionarPorNombreLJ(String nombre) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT ho FROM Hotel ho LEFT JOIN ho.habitaciones ha WHERE nombre=:nombre",
				Hotel.class);
		myQuery.setParameter("nombre", nombre);
		List<Hotel> listaHa = myQuery.getResultList();
		for (Hotel hotel : listaHa) {
			hotel.getHabitaciones().size();
		}

		return listaHa;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesPorNombreYClase(String numero, String clase) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery
				("SELECT ho FROM Hotel ho FULL JOIN ho.habitaciones ha WHERE ha.numero=:numero AND ha.clase=:clase",
				Hotel.class);
		myQuery.setParameter("numero", numero);
		myQuery.setParameter("clase", clase);
		List<Hotel> listaHa = myQuery.getResultList();
		for (Hotel hotel : listaHa) {
			hotel.getHabitaciones().size();
		}
		return listaHa;
	}

}
