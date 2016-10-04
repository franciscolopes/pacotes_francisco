package servico;

import java.util.List;

import dao.DaoFactory;
import dao.ItemDao;
import dao.PacoteDao;
import dao.Transaction;
import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;

public class ItemServico {

	private ItemDao dao;
	private PacoteDao pacoteDao;
	
	public ItemServico() {
		dao = DaoFactory.criarItemDao();
		pacoteDao = DaoFactory.criarPacoteDao();
	}
	

	private boolean existePasseio(Passeio passeio, Pacote pacote) {
		for (Item item : pacote.getItens()) {
			if (item.getPasseio().equals(passeio)) {
				return true;
			}
		}
		return false;		
	}
	
	public void inserir(Item x) throws ServicoException {
		
		Pacote pac = pacoteDao.buscar(x.getPacote().getCodPacote());
		if (existePasseio(x.getPasseio(), pac)) {
			throw new ServicoException("Já existe esse mesmo passeio cadastrado para o"+
				" hotel " + x.getPacote().getHotel().getNome() + " no pacote " + x.getPacote().getNome(), 1);
		}
		
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
	
	
	public void atualizar(Item x){
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
	
	
	
	
	
	public void excluir(Item x){
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
	
	public Item buscar(int cod){
		return dao.buscar(cod);
	}
	
	public List<Item> buscarTodos(){
		return dao.buscarTodos();
	}
	
	
	
	
	
	
	
	
	
	
}
