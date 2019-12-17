package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ClienteDAO;
import model.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean {
	Cliente cliente = new Cliente();
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String salvarCliente() {
		ClienteDAO dao = new ClienteDAO();
		dao.save(this.cliente);
		return "PrincipalCliente?faces-redirect=true";
	}
	
	public List<Cliente> getClientes(){
		return new ClienteDAO().getAllClientes();
	}
	
	public String formCliente() {
		return "PrincipalCliente?faces-redirect=true";
	}
	
	public String AddCliente() {
		return "Cliente?faces-redirect=true";
	}
	
	public String telaPrincipal() {
		return "Principal?faces-redirect=true";
	}
	
	public String carregar(Cliente cliente) {
		this.cliente = cliente;
		return "Cliente?faces-redirect=true";
	}
	
	public void remover(int clienteId) {
		new ClienteDAO().delete(clienteId);
	}
}
