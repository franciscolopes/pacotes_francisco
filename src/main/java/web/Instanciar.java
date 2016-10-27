package web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import dominio.Cliente;
import dominio.Hotel;
import dominio.Pacote;
import servico.ClienteServico;
import servico.HotelServico;

public class Instanciar {

	public static Cliente cliente(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente aux = new Cliente();
		String s;

		s = request.getParameter("codCliente");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setCodCliente(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: codCliente invalido");
			}
		}

		s = request.getParameter("nome");
		if (s != null && !s.isEmpty()) {
			aux.setNome(s);
		}

		s = request.getParameter("email");
		if (s != null && !s.isEmpty()) {
			aux.setEmail(s);
		}

		s = request.getParameter("telefone");
		if (s != null && !s.isEmpty()) {
			aux.setTelefone(s);
		}
		
		s = request.getParameter("cpf");
		if (s != null && !s.isEmpty()) {
			aux.setCpf(s);
		}
		
		
		s = request.getParameter("nascimento");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setNascimento(sdf.parse(s));
			} catch (ParseException e) {
				System.out.println("Instanciacao: nascimento invalido");
			}
		}
		
		s = request.getParameter("rendaMensal");
		if (s != null && !s.isEmpty()) {
			try {
				aux.setRendaMensal(new BigDecimal(s));
			} catch (NumberFormatException e) {
				System.out.println("Instanciacao: rendaMensal invalido");
			}
		}

		

		return aux;
	}	
}
