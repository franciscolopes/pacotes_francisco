package servico;

import java.util.List;

import dao.ItemDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Item;

public class ItemServico {

private ItemDao dao;
	
	public ItemServico() {
		dao = DaoFactory.criarItemDao();
	}
	
	
	public void inserirAtualizar(Item x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Item x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Item buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Item> buscarTodos(){
		return dao.buscarTodos();
	}
	
}
