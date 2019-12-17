package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alimento")
public class Alimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private float calorias;
	
	@Enumerated(EnumType.STRING)
	private Porcao tipoPorcao;
	
	@Enumerated(EnumType.STRING)
	private Refeicao tipoRefeicao;
	
	public Alimento() {
		
	}
	
	public Alimento(int id, String nome, float calorias, Porcao tipoPorcao, Refeicao tipoRefeicao) {
		this.id = id;
		this.nome = nome;
		this.calorias = calorias;
		this.tipoPorcao = tipoPorcao;
		this.tipoRefeicao = tipoRefeicao;
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

	public float getCalorias() {
		return calorias;
	}

	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}

	public Porcao getTipoPorcao() {
		return tipoPorcao;
	}

	public void setTipoPorcao(Porcao tipoPorcao) {
		this.tipoPorcao = tipoPorcao;
	}

	public Refeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(Refeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}
	
//	public String getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(String categoria) {
//		this.categoria = categoria;
//	}
}
