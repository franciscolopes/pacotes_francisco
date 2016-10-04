package dao;

import java.util.List;

import dominio.Hotel;
import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;

public interface ItemDao {
	
	public void inserirAtualizar(Item x);
	public void excluir(Item x);
	public Item buscar(int cod);
	public List<Item> buscarTodos();

	
	
}
