package servico;

import java.math.BigDecimal;
import java.util.List;

import dao.DaoFactory;
import dao.HotelDao;
import dao.Transaction;
import dominio.Hotel;

public class HotelServico {
	
private HotelDao dao;
	
	public HotelServico() {
		dao = DaoFactory.criarHotelDao();
	}
	
	
	public void inserirAtualizar(Hotel x){
		try {
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
	
	public void excluir(Hotel x){
		try {
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
	
	public Hotel buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Hotel> buscarTodos(){
		return dao.buscarTodos();
	}
	
	
	public List<Hotel> buscaPorNomeOrdenadoPorPreco(String nome, BigDecimal diariaMin, BigDecimal diariaMax){
		return dao.buscaPorNomeOrdenadoPorPreco(nome, diariaMin, diariaMax);

	}
	
	

}
