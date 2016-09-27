package dao;

import java.util.List;

import dominio.Item;

public interface ItemDao {
	
	public void inserirAtualizar(Item x);
	public void excluir(Item x);
	public Item buscar(int cod);
	public List<Item> buscarTodos();
	

}
