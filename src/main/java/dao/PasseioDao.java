package dao;

import java.util.List;

import dominio.Passeio;

public interface PasseioDao {
	
	public void inserirAtualizar(Passeio x);
	public void excluir(Passeio x);
	public Passeio buscar(int cod);
	public List<Passeio> buscarTodos();
	

}
