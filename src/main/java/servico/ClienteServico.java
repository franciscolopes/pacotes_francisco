package servico;

import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Cliente;

public class ClienteServico {
	
private ClienteDao dao;
	
	public ClienteServico() {
		dao = DaoFactory.criarClienteDao();
	}
	
	
	public void inserirAtualizar(Cliente x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Cliente x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Cliente buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Cliente> buscarTodos(){
		return dao.buscarTodos();
	}

}
