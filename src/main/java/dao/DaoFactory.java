package dao;

import dao.impl.ClienteDaoImpl;
import dao.impl.ContratoDaoImpl;
import dao.impl.HotelDaoImpl;
import dao.impl.ItemDaoImpl;
import dao.impl.PacoteDaoImpl;
import dao.impl.PasseioDaoImpl;

public class DaoFactory {
	
	public static ClienteDao criarClienteDao(){
		return new ClienteDaoImpl();
	}
	
	public static ContratoDao criarContratoDao(){
		return new ContratoDaoImpl();
	}
	
	public static HotelDao criarHotelDao(){
		return new HotelDaoImpl();
	}
	
	public static ItemDao criarItemDao(){
		return new ItemDaoImpl();
	}
	
	public static PacoteDao criarPacoteDao(){
		return new PacoteDaoImpl();
	}
	
	public static PasseioDao criarPasseioDao(){
		return new PasseioDaoImpl();
	}

}
