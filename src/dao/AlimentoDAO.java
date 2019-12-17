package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.JPAUtil;
import model.Alimento;

public class AlimentoDAO {
	private EntityManager manager;
	
	public AlimentoDAO() {
		this.manager = JPAUtil.getEntityManagerFactory()
				.createEntityManager();
	}
	
	public void save(Alimento alimento) {
		manager.getTransaction().begin();
		if (alimento.getId() == 0) {
			manager.persist(alimento);
		} else {
			manager.merge(alimento);
		}
		manager.getTransaction().commit();
	}
	
	public Alimento getAlimentoId(int id) {
		Alimento alimento = this.manager.find(Alimento.class, id);
		return alimento;
	}
	
	public void delete(int id) {
		Alimento alimento = manager.find(Alimento.class, id);
		manager.getTransaction().begin();
		manager.remove(alimento);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Alimento> getAllAlimentos(){
		Query query = manager.createQuery("select a from Alimento a");
		return query.getResultList();
	}
}
