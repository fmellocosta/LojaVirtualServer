package br.com.casa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
 
	public ProdutoDAO(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	public int add(ProdutoEntity produtoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(produtoEntity);
		this.entityManager.getTransaction().commit();
		return produtoEntity.getId();
	}
 
	public void update(ProdutoEntity produtoEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(produtoEntity);
		this.entityManager.getTransaction().commit();
	}
 
	@SuppressWarnings("unchecked")
	public List<ProdutoEntity> getAll(){
		return this.entityManager.createQuery("SELECT p FROM ProdutoEntity p ORDER BY p.nome").getResultList();
	}	
	
	public ProdutoEntity get(Integer codigo){
		return this.entityManager.find(ProdutoEntity.class, codigo);
	}
 
	public void delete(Integer codigo){
		ProdutoEntity produto = this.get(codigo);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(produto);
		this.entityManager.getTransaction().commit();
	}	
	
}
