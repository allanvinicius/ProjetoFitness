package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	@Column(length = 11, unique = true)
	private String telefone;
	
    private String email;
	
	private float pesoAtual;
	private float pesoDesejado;
	
	public Cliente() {
	}
	
	public Cliente(int id, String nome, String telefone, String email, float pesoAtual, float pesoDesejado) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.pesoAtual = pesoAtual;
		this.pesoDesejado = pesoDesejado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(float pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public float getPesoDesejado() {
		return pesoDesejado;
	}

	public void setPesoDesejado(float pesoDesejado) {
		this.pesoDesejado = pesoDesejado;
	}
}
