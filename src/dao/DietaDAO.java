package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.JPAUtil;
import model.Alimento;
import model.Dieta;

public class DietaDAO {
	private EntityManager manager;
	
	public DietaDAO() {
		this.manager = JPAUtil.getEntityManagerFactory()
				.createEntityManager();
	}
	
	public void save(Dieta dieta) {
		this.manager.getTransaction().begin();
		if (dieta.getId() == 0) {
			this.manager.persist(dieta);
		} else {
			this.manager.merge(dieta);
		}
		this.manager.getTransaction().commit();
	}
	
	public Dieta getDietaId(int id) {
		Dieta dieta = this.manager.find(Dieta.class, id);
		return dieta;
	}
	
	public void delete(int id) {
		Dieta dieta = manager.find(Dieta.class, id);
		manager.getTransaction().begin();
		manager.remove(dieta);
		manager.getTransaction().commit();
		manager.close();
	}
	
//	public void adicionar(int id) {
//		Alimento alimento = manager.find(Alimento.class, id);
//		manager.getTransaction().begin();
//		manager.persist(alimento);
//		
//		manager.getTransaction().commit();
//		manager.close();
//	}
	
	public List<Dieta> getAllDietas(){
		Query query = manager.createQuery("select a from Dieta a");
		return query.getResultList();
	}
}