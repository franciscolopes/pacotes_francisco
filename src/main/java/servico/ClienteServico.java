package servico;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Cliente;

public class ClienteServico {
	
private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	
	public void validar(Cliente x) throws ValidacaoException {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getEmail()==null) {
			erros.add("Favor preencher o campo email");
		}
		if (x.getTelefone()==null) {
			erros.add("Favor preencher o campo telefone");
		}
		if (x.getCpf()==null) {
			erros.add("Favor preencher o campo cpf");
		}
		
		if (x.getNascimento()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		
		if (x.getRendaMensal()==null) {
			erros.add("Favor preencher um valor válido para a renda mensal");
		}
		
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	
	
	
	public void inserir(Cliente x)  throws ServicoException {
		try {
			
			
			Cliente aux = dao.buscaCpf(x.getCpf());
			if (aux != null) {
				throw new ServicoException("Já existe um cliente com esse cpf!", 1);
			}

			
			
			
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
	
	

	public void atualizar(Cliente x)  throws ServicoException {
		try {
			
			Cliente aux = dao.buscaCpfDiferente(x.getCodCliente(), x.getCpf());
			if (aux != null) {
				throw new ServicoException("Já existe um cliente com esse cpf!", 1);
			}
			
			
			

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
	
	
	
	
	
	
	

	public void excluir(Cliente x) throws ServicoException {
		try {
			
			
			x = dao.buscar(x.getCodCliente());
			if (!x.getContratos().isEmpty()) {
				throw new ServicoException("Exclusão não permitida: este cliente possui contratos!", 2);
			
			}
			

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
	
	public Cliente buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos(){
		return dao.buscarTodos();
	}

	
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}
	
	public List<Cliente> buscarPorNome(String trecho) {
		return dao.buscarPorNome(trecho);
	}
	
	
}
