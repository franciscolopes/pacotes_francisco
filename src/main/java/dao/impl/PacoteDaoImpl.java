package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PacoteDao;
import dominio.Pacote;

public class PacoteDaoImpl implements PacoteDao {

	private EntityManager em;
	
	public PacoteDaoImpl(){
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Pacote x) {
		if (x.getCodPacote() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Pacote x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Pacote buscar(int cod) {
		return em.find(Pacote.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarTodos() {
		String jpql = "SELECT x FROM Pacote x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}
