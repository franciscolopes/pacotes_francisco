package servico;

import java.util.List;

import dao.ContratoDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Contrato;

public class ContratoServico {
	
	private ContratoDao dao;
	
	public ContratoServico() {
		dao = DaoFactory.criarContratoDao();
	}
	
	public void inserirAtualizar(Contrato x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Contrato x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Contrato buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Contrato> buscarTodos(){
		return dao.buscarTodos();
	}

}
