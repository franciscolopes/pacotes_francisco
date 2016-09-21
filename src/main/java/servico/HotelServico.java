package servico;

import java.util.List;

import dao.HotelDao;
import dao.DaoFactory;
import dao.impl.EM;
import dominio.Hotel;

public class HotelServico {
	
private HotelDao dao;
	
	public HotelServico() {
		dao = DaoFactory.criarHotelDao();
	}
	
	
	public void inserirAtualizar(Hotel x){
		EM.getLocalEm().getTransaction().begin();
		dao.inserirAtualizar(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public void excluir(Hotel x){
		EM.getLocalEm().getTransaction().begin();
		dao.excluir(x);
		EM.getLocalEm().getTransaction().commit();
	}
	
	public Hotel buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Hotel> buscarTodos(){
		return dao.buscarTodos();
	}

}
