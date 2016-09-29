package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ItemDao;
import dominio.Item;

public class ItemDaoImpl implements ItemDao {

	private EntityManager em;
	
	public ItemDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Item x) {
		if (x.getCodItem() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Item x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Item buscar(int cod) {
		return em.find(Item.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> buscarTodos() {
		String jpql = "SELECT x FROM Item x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
