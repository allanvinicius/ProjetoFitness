package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dieta")
public class Dieta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Alimento> alimentos;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Cliente> clientes;
	
	private String nomeDieta;
	
	public Dieta() {
	}

	public Dieta(int id, String nomeDieta) {
		this.id = id;
		this.nomeDieta = nomeDieta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDieta() {
		return nomeDieta;
	}

	public void setNomeDieta(String nomeDieta) {
		this.nomeDieta = nomeDieta;
	}
	
	//Alimentos
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
	public void setAlimento(Alimento alimento) {
		this.alimentos.add(alimento);
	}
	
	//Clientes
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void setCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
}