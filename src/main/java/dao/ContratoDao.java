package dao;

import java.util.List;

import dominio.Contrato;

public interface ContratoDao {
	
	public void inserirAtualizar(Contrato x);
	public void excluir(Contrato x);
	public Contrato buscar(int cod);
	public List<Contrato> buscarTodos();
	

}
