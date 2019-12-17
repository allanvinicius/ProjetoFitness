package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AlimentoDAO;
import dao.ClienteDAO;
import dao.DietaDAO;
import model.Alimento;
import model.Cliente;
import model.Dieta;

@ManagedBean
@SessionScoped
public class DietaBean {
	Dieta dieta = new Dieta();
	Alimento alimento = new Alimento();
	
	private int clienteId;
	private int alimentoId;
	private float valor = 0;
	
	public Dieta getDieta() {
		return dieta;
	}
	
	public String salvarDieta() {
		DietaDAO dao = new DietaDAO();
		dao.save(this.dieta);
		//this.dieta = new Dieta();
		return "PrincipalDieta?faces-redirect=true";
	}
	
	public void salvarAlimento() {
		Alimento alimento = new AlimentoDAO().getAlimentoId(this.alimentoId);
		
		this.dieta.setAlimento(alimento);
	}
	
	public void SalvarCliente() {
		Cliente cliente = new ClienteDAO().getClienteId(this.clienteId);
		
		this.dieta.setCliente(cliente);
	}
	
	public List<Alimento> getAlimentoDaDieta(){
		return this.dieta.getAlimentos();
	}
	
	public List<Cliente> getClienteDaDieta(){
		return this.dieta.getClientes();
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	
	public List<Cliente> getClientes(){
		return new ClienteDAO().getAllClientes();
	}

	public int getAlimentoId() {
		return alimentoId;
	}

	public void setAlimentoId(int alimentoId) {
		this.alimentoId = alimentoId;
	}
	
	public List<Alimento> getAlimentos() {
		return new AlimentoDAO().getAllAlimentos();
	}

	public String formDieta() {
		return "PrincipalDieta?faces-redirect=true";
	}
	
	public String AddDieta() {
		return "Dieta?faces-redirect=true";
	}
	
	public String InfoDieta(Dieta dieta) {
		this.dieta = dieta;
		return "InfoDieta?faces-redirect=true";
	}
	
	public String carregar(Dieta dieta) {
		this.dieta = dieta;
		return "Dieta?faces-redirect=true";
	}
	
	public void remover(int dietaId) {
		new DietaDAO().delete(dietaId);
	}
	
	public List<Dieta> getDietas(){
		return new DietaDAO().getAllDietas();
	}
	
	public String telaPrincipal() {
		return "Principal?faces-redirect=true";
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float calcularCalorias() {
		this.valor = this.alimento.getCalorias() + this.valor;
		return valor;
	}
	
//	public void adicionar(int dietaId) {
//		new DietaDAO().adicionar(dietaId);
//	}
}
