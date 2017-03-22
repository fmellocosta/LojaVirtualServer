package br.com.casa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.casa.dao.ProdutoDAO;
import br.com.casa.dao.ProdutoEntity;
import br.com.casa.resource.Produto;

@Path("/produto")
public class ProdutoController {

	private final ProdutoDAO produtoDAO = new ProdutoDAO();
	
	@POST	
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/cadastrar")	
	public ProdutoEntity cadastrar(Produto produto) {
		
		ProdutoEntity entity = new ProdutoEntity();
		
		entity.setNome(produto.getNome());
		entity.setPreco(produto.getPreco());
		entity.setImagem(produto.getImagem());
		entity.setId(produtoDAO.add(entity));
		
		return entity;
		
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/listar")
	public List<Produto> listar(){
 
		List<Produto> produtos =  new ArrayList<Produto>();
		List<ProdutoEntity> listaProdutos = produtoDAO.getAll();
 
		for (ProdutoEntity entity : listaProdutos) {
			produtos.add(new Produto(entity.getId(), entity.getNome(), entity.getPreco(), entity.getImagem()));
		}
 
		return produtos;
	}
	
}
