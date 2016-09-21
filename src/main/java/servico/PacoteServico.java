package servico;

import java.util.List;

import dao.DaoFactory;
import dao.PacoteDao;
import dao.Transaction;
import dominio.Pacote;

public class PacoteServico {
	
private PacoteDao dao;
	
	public PacoteServico() {
		dao = DaoFactory.criarPacoteDao();
	}
	
	
	public void inserirAtualizar(Pacote x){
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Pacote x){
		try {
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch (RuntimeException e) {
			if (Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Pacote buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Pacote> buscarTodos(){
		return dao.buscarTodos();
	}

}
