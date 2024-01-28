package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

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
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {

		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {

		this.entityManager.persist(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public Hotel seleccionarDireccion(String direccion) {
		TypedQuery<Hotel> consulta = this.entityManager
				.createQuery("SELECT ha FROM Habitacion ha WHERE ha.hotel.direccion=:direccion ", Hotel.class);
		consulta.setParameter("direccion", direccion);
		return consulta.getSingleResult();
	}

	@Override
	public Habitacion seleccionarPorClase(String clase) {
		Query consulta = this.entityManager.createNativeQuery("SELECT * FROM habitacion ha WHERE ha.hab_clase=:clase",
				Habitacion.class);
		consulta.setParameter("clase", clase);
		return (Habitacion) consulta.getSingleResult();
	}

	@Override
	public List<Habitacion> seleccionarPorNumero(String numero) {
		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Habitacion> myCriteriaQuery = myCriteriaBuilder.createQuery(Habitacion.class);
		Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);
		Predicate condicionNumero = myCriteriaBuilder.greaterThanOrEqualTo(myFrom.get("numero"), numero);
		myCriteriaQuery.select(myFrom).where(condicionNumero);
		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);
		return myTypedQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarPorClaseC(String clase,String numero ) {

		CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Habitacion> myCriteriaQuery = myCriteriaBuilder.createQuery(Habitacion.class);
		Root<Habitacion> myFrom = myCriteriaQuery.from(Habitacion.class);

		Predicate condicionGenerica = null;

		if (clase.equals("premium")) {
			condicionGenerica = myCriteriaBuilder.lessThanOrEqualTo(myFrom.get("numero"), numero);

		} else {
			condicionGenerica = myCriteriaBuilder.greaterThanOrEqualTo(myFrom.get("numero"), numero);
		}

		myCriteriaQuery.select(myFrom).where(condicionGenerica);

		TypedQuery<Habitacion> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

		return myTypedQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarPorClaseIJ(String clase) {
		TypedQuery<Habitacion> myQuery = this.entityManager.createQuery("SELECT ha FROM Habitacion ha LEFT JOIN ha.hotel ho WHERE clase=:clase",
				Habitacion.class);
		myQuery.setParameter("clase", clase);
		
		return myQuery.getResultList();
	}

}
