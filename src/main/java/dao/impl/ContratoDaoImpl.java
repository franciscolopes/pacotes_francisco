package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ContratoDao;
import dominio.Contrato;

public class ContratoDaoImpl implements ContratoDao {

	private EntityManager em;
	
	public ContratoDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Contrato x) {
		if (x.getCodContrato() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Contrato x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Contrato buscar(int cod) {
		return em.find(Contrato.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> buscarTodos() {
		String jpql = "SELECT x FROM Contrato x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
