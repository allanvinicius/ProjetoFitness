package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.JPAUtil;
import model.Cliente;

public class ClienteDAO {
	private EntityManager manager;
	
	public ClienteDAO() {
		this.manager = JPAUtil.getEntityManagerFactory()
				.createEntityManager();
	}
	
	public void save(Cliente cliente) {
		manager.getTransaction().begin();
		if (cliente.getId() == 0) {
			manager.persist(cliente);
		} else {
			manager.merge(cliente);
		}
		manager.getTransaction().commit();
	}
	
	public Cliente getClienteId(int id) {
		Cliente cliente = this.manager.find(Cliente.class, id);
		return cliente;
	}
	
	public void delete(int id) {
		Cliente cliente = manager.find(Cliente.class, id);
		manager.getTransaction().begin();
		manager.remove(cliente);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Cliente> getAllClientes(){
		Query query = manager.createQuery("select a from Cliente a");
		return query.getResultList();
	}
}
