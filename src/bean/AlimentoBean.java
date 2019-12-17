package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.AlimentoDAO;
import model.Alimento;

@ManagedBean
@SessionScoped
public class AlimentoBean {
	Alimento alimento = new Alimento();
	
	private int alimentoId;
	
	public Alimento getAlimento() {
		return alimento;
	}
	
	public String salvarAlimento() {
		AlimentoDAO dao = new AlimentoDAO();
		dao.save(this.alimento);
		return "PrincipalAlimento?faces-redirect=true";
	}
	
	public String formAlimento() {
		return "PrincipalAlimento?faces-redirect=true";
	}
	
	public String AddAlimento() {
		return "Alimento?faces-redirect=true";
	}
	
	public String telaPrincipal() {
		return "Principal?faces-redirect=true";
	}

	public int getAlimentoId() {
		return alimentoId;
	}

	public void setAlimentoId(int alimentoId) {
		this.alimentoId = alimentoId;
	}
	
	public List<Alimento> getAlimentos(){
		return new AlimentoDAO().getAllAlimentos();
	}
	
	public String carregar(Alimento alimento) {
		this.alimento = alimento;
		return "Alimento?faces-redirect=true";
	}
	
	public void remover(int alimentoId) {
		new AlimentoDAO().delete(alimentoId);
	}
	
}
