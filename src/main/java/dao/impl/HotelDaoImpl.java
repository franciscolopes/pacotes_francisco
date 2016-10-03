package dao.impl;

import java.math.BigDecimal;
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
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscaPorNomeOrdenadoPorPreco(String nome, BigDecimal diariaMin, BigDecimal diariaMax) {
		String jpql = "SELECT x FROM Hotel x WHERE x.nome LIKE :p1 AND x.diaria >= :p2 AND x.diaria <= :p3 ORDER BY x.diaria";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		query.setParameter("p2", diariaMin);
		query.setParameter("p3", diariaMax);
		return query.getResultList();
	}
	
	
	
	

}
