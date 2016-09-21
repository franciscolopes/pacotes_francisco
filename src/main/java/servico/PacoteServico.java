package servico;

import java.util.List;

import dao.PacoteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Pacote;

public class PacoteServico {
	
private PacoteDao dao;
	
	public PacoteServico() {
		dao = DaoFactory.criarPacoteDao();
	}
	
	
	public void inserirAtualizar(Pacote x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Pacote x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Pacote buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Pacote> buscarTodos(){
		return dao.buscarTodos();
	}

}
