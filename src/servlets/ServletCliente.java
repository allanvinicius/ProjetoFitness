package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet({ "/ServletCliente", "/servletcliente" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		int id;
		Cliente cliente;
		ClienteDAO dao = new ClienteDAO();
		
		switch (action) {
		case "edit":
			id = Integer.parseInt(request.getParameter("id"));
			cliente = dao.getClienteId(id);
			
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("formcliente.jsp").forward(request, response);
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			response.sendRedirect("listaclientes.jsp");
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDAO dao = new ClienteDAO();
		if (request.getParameter("id").isEmpty()) {
			Cliente cliente = new Cliente();
			
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			//cliente.setSenha(request.getParameter("senha"));
			cliente.setPesoAtual(Float.parseFloat(request.getParameter("pesoAtual")));
			cliente.setPesoDesejado(Float.parseFloat(request.getParameter("pesoDesejado")));
			
			
			//Salvar
			dao.save(cliente);
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Cliente cliente = dao.getClienteId(id);
			
			cliente.setNome(request.getParameter("nome"));
			cliente.setEmail(request.getParameter("email"));
			cliente.setTelefone(request.getParameter("telefone"));
			//cliente.setSenha(request.getParameter("senha"));
			cliente.setPesoAtual(Float.parseFloat(request.getParameter("pesoAtual")));
			cliente.setPesoDesejado(Float.parseFloat(request.getParameter("pesoDesejado")));

			//Salvar
			dao.save(cliente);
		}
		response.sendRedirect("listaclientes.jsp");
	}

}
