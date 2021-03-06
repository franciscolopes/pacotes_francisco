package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	
	public void inserirAtualizar(Cliente x);
	public void excluir(Cliente x);
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	
	public List<Cliente> buscarTodosOrdenadosPorNome();
	public List<Cliente> buscarPorNome(String trecho);
	public Cliente buscaCpf(String cpf);
	public Cliente buscaCpfDiferente(Integer codigo, String cpf);

}
