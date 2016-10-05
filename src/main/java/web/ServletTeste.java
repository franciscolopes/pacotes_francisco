package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;
import servico.ContratoServico;
import servico.HotelServico;
import servico.ItemServico;
import servico.PacoteServico;
import servico.PasseioServico;
import servico.ServicoException;

@WebServlet("/ServletTeste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.parse("01/01/2000");
			
			
			//declaração dos objetos das classes serviços
			ClienteServico cls = new ClienteServico();
			HotelServico hs = new HotelServico();
			PasseioServico pss = new PasseioServico();
			PacoteServico ps = new PacoteServico();
			ItemServico is = new ItemServico();
			ContratoServico crs = new ContratoServico();
		
			
/*			
			//inserir cliente
			
			Cliente cl1 = new Cliente(null, "Carla Maria Silva", "carla@hotmail.com", "(32) 99145-7548", "115.222.323-4", sdf.parse("25/09/1996"), new BigDecimal("4000.00"));
			try {
				cls.inserir(cl1);
				response.getWriter().append("Carla Maria Silva inserida!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}*/
			
			
/*			
			//consultar cliente
			List<Cliente> lista = cls.buscarTodosOrdenadosPorNome();
			for (Cliente x : lista) {
				response.getWriter().append(x + "\n");
			}*/
			
			
			
			
/*			
			//alterar cliente
			Cliente c1 = cls.buscar(1);
			try {
				c1.setNome("Helena Candida");
				c1.setCpf("100.905.106.78");
				c1.setTelefone("(11) 3956-2587");
				c1.setEmail("helenacandida@gmail.com");
				c1.setNascimento(sdf.parse("25/09/1996"));
				c1.setRendaMensal(new BigDecimal("1511.00"));
				cls.atualizar(c1);
				response.getWriter().append("Cliente atualizado!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}*/
			
			
			
			
			
			
			//excluir cliente
			/* Cliente c1 = cls.buscar(1);
			try {
				
				cls.excluir(c1);
				response.getWriter().append("Cliente atualizado!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}*/
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 

/*			
			//inserir cliente com cpf repetido

			
			Cliente cl1 = new Cliente(null, "Carla Maria Silva", "carla@hotmail.com", "(32) 99145-7548", "115.222.323-4", sdf.parse("25/09/1996"), new BigDecimal("4000.00"));
			try {
				cls.inserir(cl1);
				response.getWriter().append("Carla Maria Silva inserida!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}*/
			
			
			
			
			
			
			//alterar cliente com cpf repetido
			
			Cliente c1 = cls.buscar(2);
			try {
				c1.setNome("Helena Tosta");
				c1.setCpf("100.905.106.78");
				c1.setTelefone("(11) 3956-2587");
				c1.setEmail("helenacandida@gmail.com");
				c1.setNascimento(sdf.parse("25/09/1996"));
				c1.setRendaMensal(new BigDecimal("1511.00"));
				cls.atualizar(c1);
				response.getWriter().append("Cliente atualizado!\n");
			}
			catch (ServicoException e) {
				response.getWriter().append(e.getMessage()+"\n");
			}
			
			
			
			
			
			//excluir cliente que possui contratos cadastrados
			
			//pesquisar hotel
			
			//incluir item de pacote
			
			//incluir item de pacote que já contem o passeio selecionado
			
		
		}
		catch (ParseException e) {
			response.getWriter().append("Data inválida!");
		}
		
		
		
	}

}
