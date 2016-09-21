package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemDao;
import dao.Transaction;
import dominio.Item;

public class ItemServico {

private ItemDao dao;
	
	public ItemServico() {
		dao = DaoFactory.criarItemDao();
	}
	
	
	public void inserirAtualizar(Item x){
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
	
	public void excluir(Item x){
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
	
	public Item buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Item> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
