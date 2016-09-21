package dao;

import java.util.List;

import dominio.Hotel;

public interface HotelDao {
	
	public void inserirAtualizar(Hotel x);
	public void excluir(Hotel x);
	public Hotel buscar(int cod);
	public List<Hotel> buscarTodos();
	

}
