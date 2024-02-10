package com.uce.edu.ventas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value =  TxType.NOT_SUPPORTED)
	public Factura seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value =  TxType.MANDATORY)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	@Transactional(value =  TxType.MANDATORY)
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	@Transactional(value =  TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));

	}

	@Override
	public Factura seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> miConsulta = this.entityManager
				.createQuery("SELECT f FROM Factura f WHERE f.numero =: numero", Factura.class);
		miConsulta.setParameter("numero", numero);
		Factura fac = miConsulta.getSingleResult();
		fac.getDetalles().size();// le digo que carge el detalle bajo demanda
		return fac;

	}

	@Override
	public List<Factura> seleccionarInnerJoin() {
		// SQL: SELECT * FROM factura f inner join detalle_factura don f.fact_id=defa_id_factura
		// JPQL: SELECT f FROM Factura f INNER JOIN f.detalleFactura d
		// JPQL: SELECT f FROM Factura f JOIN f.detalleFactura d
		//select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura d1_0 on f1_0.fact_id=d1_0.defa_id_factura
		//select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura d1_0 on f1_0.fact_id=d1_0.defa_id_factura

		TypedQuery<Factura> myQuery 
		= this.entityManager.createQuery
		("SELECT f FROM Factura f JOIN f.detalles d",Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalles().size();
		}
		
		return lista;
	}

	@Override
	public List<Factura> seleccionarRightJoin() {
		TypedQuery<Factura> myQuery 
		= this.entityManager.createQuery
		("SELECT f FROM Factura f RIGHT JOIN f.detalles d",Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalles().size();
		}
		
		return lista;
	}

	@Override
	public List<Factura> seleccionarLeftJoin() {
		TypedQuery<Factura> myQuery 
		= this.entityManager.createQuery
		("SELECT f FROM Factura f LEFT JOIN f.detalles d",Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalles().size();
		}
		
		return lista;
	}

	@Override
	public List<Factura> seleccionarFullJoin() {
		TypedQuery<Factura> myQuery 
		= this.entityManager.createQuery
		("SELECT f FROM Factura f FULL JOIN f.detalles d",Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalles().size();
		}
		
		return lista;
	}

	@Override
	public List<Factura> seleccionarFactura(String numero) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Factura> myCriteriaQuery=myCriteria.createQuery(Factura.class);
		
		Root<Factura> myFrom=myCriteriaQuery.from(Factura.class);//from ciudadano
		myFrom.join("detalleFactura");
		Predicate condicionApellido=myCriteria.equal(myFrom.get("apellido"), numero); //condicion
		//construir el sql final
		myCriteriaQuery.select(myFrom).where(condicionApellido);
		//Ejecutamos la consulta con un typedQuery
		TypedQuery<Factura> myTypedQuery=this.entityManager.createQuery(myCriteriaQuery);
		
		return myTypedQuery.getResultList();
	}

	@Override
	public List<Factura> seleccionarFacturaWhereJoin() {
		TypedQuery<Factura> myQuery = 
				this.entityManager.createQuery
				("SELECT f FROM Factura f, DetalleFactura d WHERE f= d.factura",
				Factura.class);
		List<Factura> lista = myQuery.getResultList();
		for (Factura factura : lista) {
			factura.getDetalles().size();
		}
		
		return lista;
	}

	@Override
	public List<Factura> seleccionarFacturaFetchJoin() {
		// el fetch va a la derecha del join 
		TypedQuery<Factura> myQuery = 
				this.entityManager.createQuery
				("SELECT f FROM Factura f JOIN FETCH f.detalles d",
				Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for (Factura factura : lista) {
//			factura.getDetalles().size();
//		}
		
		return lista;
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// primera manera
		//select
		//Lista
		//recorrer lista
		// por cada factura seteo la nueva fecha
		//Actualizar cada factura
		
		//SQL: UPDATE factura set fact_fecha=:fechaNueva where fact_fecha>= fechaActual
		//JPQL:UPDATE Factura f SET f.fecha=:fechaNueva WHERE f.fecha>= fechaActual
	Query myQuery = this.entityManager.createQuery("UPDATE Factura f SET f.fecha=:fechaNueva WHERE f.fecha>=:fechaActual");
	myQuery.setParameter("fechaNueva", fechaNueva);
	myQuery.setParameter("fechaActual", fechaActual);
	// devuelve una cantidad de lo que se actualizo
	return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorNumero(String numero) {
		Query myQuery = 
				this.entityManager.createQuery("DELETE FROM Factura f WHERE f.numero=:numero");
		myQuery.setParameter("numero", numero);
		return myQuery.executeUpdate();
	}

	@Override
	public List<FacturaDTO> seleccionarFacturasDTO() {
		TypedQuery<FacturaDTO> consulta = this.entityManager.createQuery("SELECT NEW com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero,f.fecha) FROM Factura f",FacturaDTO.class);
		return consulta.getResultList();
	}
	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public List<Factura> seleccionarTodos() {
		TypedQuery<Factura> myQuery 
		= this.entityManager.createQuery
		("SELECT f FROM Factura f",Factura.class);
		List<Factura> lista = myQuery.getResultList();
//		for (Factura factura : lista) {
//			factura.getDetalles().size();
//		}
//		
		return lista;
	}
}
