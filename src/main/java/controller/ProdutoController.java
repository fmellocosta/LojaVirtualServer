package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.ProdutoDao;
import dao.ProdutoEntity;
import resource.Produto;

@Path("/produto")
public class ProdutoController {

	private final ProdutoDao produtoDAO = new ProdutoDao();
	
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
	
}
