package br.com.casa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PedidoDAO {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
 
	public PedidoDAO(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	public int add(PedidoEntity pedidoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(pedidoEntity);
		this.entityManager.getTransaction().commit();
		return pedidoEntity.getId();		
	}
 
	public void update(PedidoEntity pedidoEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(pedidoEntity);
		this.entityManager.getTransaction().commit();
	}
 
	@SuppressWarnings("unchecked")
	public List<PedidoEntity> getAll(){
		return this.entityManager.createQuery("SELECT ped FROM PedidoEntity ped ORDER BY ped.id").getResultList();
	}	
	
	public PedidoEntity get(Integer codigo){
		return this.entityManager.find(PedidoEntity.class, codigo);
	}
 
	public void delete(Integer codigo){
		PedidoEntity pedido = this.get(codigo);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(pedido);
		this.entityManager.getTransaction().commit();
	}	
	
}
