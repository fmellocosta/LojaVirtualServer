package br.com.casa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.casa.dao.ProdutoDAO;
import br.com.casa.dao.ProdutoEntity;
import br.com.casa.resource.Produto;

@Path("/produto")
public class ProdutoController {

	private final ProdutoDAO produtoDAO = new ProdutoDAO();
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")	
	public String cadastrar(Produto produto) {
		
		ProdutoEntity entity = new ProdutoEntity();
		
		try {
			entity.setNome(produto.getNome());
			entity.setPreco(produto.getPreco());
			produtoDAO.add(entity);
			return "Produto cadastrado com sucesso!";
		} catch (Exception e) {
			return "Erro ao cadastrar um produto: " + e.getMessage();
		}		
		
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public List<Produto> listar(){
 
		List<Produto> produtos =  new ArrayList<Produto>();
		List<ProdutoEntity> listaProdutos = produtoDAO.getAll();
 
		for (ProdutoEntity entity : listaProdutos) {
			produtos.add(new Produto(entity.getId(), entity.getNome(),entity.getPreco()));
		}
 
		return produtos;
	}
	
}
