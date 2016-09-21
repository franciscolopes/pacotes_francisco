package servico;

import java.util.List;

import dao.DaoFactory;
import dao.PasseioDao;
import dao.Transaction;
import dominio.Passeio;

public class PasseioServico {
	
private PasseioDao dao;
	
	public PasseioServico() {
		dao = DaoFactory.criarPasseioDao();
	}
	
	public void inserirAtualizar(Passeio x){
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
	
	public void excluir(Passeio x){
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
	
	public Passeio buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Passeio> buscarTodos(){
		return dao.buscarTodos();
	}

}
