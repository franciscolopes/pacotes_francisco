package servico;

import java.util.List;

import dao.ContratoDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Contrato;

public class ContratoServico {
	
	private ContratoDao dao;
	
	public ContratoServico() {
		dao = DaoFactory.criarContratoDao();
	}
	
	public void inserirAtualizar(Contrato x){
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
	
	public void excluir(Contrato x){
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
	
	public Contrato buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Contrato> buscarTodos(){
		return dao.buscarTodos();
	}

}
