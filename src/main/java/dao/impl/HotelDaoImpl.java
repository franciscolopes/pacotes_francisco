package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.HotelDao;
import dominio.Hotel;

public class HotelDaoImpl implements HotelDao {

	private EntityManager em;
	
	public HotelDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Hotel x) {
		if (x.getCodHotel() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Hotel x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Hotel buscar(int cod) {
		return em.find(Hotel.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscarTodos() {
		String jpql = "SELECT x FROM Hotel x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
