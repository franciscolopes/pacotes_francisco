package dao;

import java.util.List;

import dominio.Pacote;

public interface PacoteDao {
	
	public void inserirAtualizar(Pacote x);
	public void excluir(Pacote x);
	public Pacote buscar(int cod);
	public List<Pacote> buscarTodos();
	

}
