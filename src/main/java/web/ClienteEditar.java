package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import servico.ClienteServico;

@WebServlet("/cliente/editar")
public class ClienteEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String DESTINO = "/cliente/formEditar.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteServico cs = new ClienteServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Cliente cli = cs.buscar(cod);
		request.setAttribute("item", cli);
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}
}
