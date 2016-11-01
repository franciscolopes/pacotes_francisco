package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/cliente/remover")
public class ClienteRemover extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/cliente/confirmarExclusao.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteServico as = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Cliente cli = as.buscar(cod);
		request.setAttribute("item", cli);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
