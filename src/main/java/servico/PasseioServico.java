package servico;

import java.util.List;

import dao.PasseioDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Passeio;

public class PasseioServico {
	
private PasseioDao dao;
	
	public PasseioServico() {
		dao = DaoFactory.criarPasseioDao();
	}
	
	public void inserirAtualizar(Passeio x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Passeio x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Passeio buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Passeio> buscarTodos(){
		return dao.buscarTodos();
	}

}
