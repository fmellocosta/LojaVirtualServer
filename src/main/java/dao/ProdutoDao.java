package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDao {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
 
	public ProdutoDao(){
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	public void add(ProdutoEntity produtoEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(produtoEntity);
		this.entityManager.getTransaction().commit();
	}
 
	public void update(ProdutoEntity produtoEntity){
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(produtoEntity);
		this.entityManager.getTransaction().commit();
	}
 
	public ProdutoEntity get(Integer codigo){
		return this.entityManager.find(ProdutoEntity.class, codigo);
	}
 
	public void Excluir(Integer codigo){
		ProdutoEntity produto = this.get(codigo);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(produto);
		this.entityManager.getTransaction().commit();
	}	
	
}
