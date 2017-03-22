package br.com.casa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.casa.dao.PedidoDAO;
import br.com.casa.dao.PedidoEntity;
import br.com.casa.resource.Pedido;
import br.com.casa.resource.Produto;

@Path("/pedido")
public class PedidoController {

	private final PedidoDAO pedidoDAO = new PedidoDAO();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/listar")
	public List<Pedido> listar(){
 
		List<Pedido> pedidos =  new ArrayList<Pedido>();
		List<PedidoEntity> listaPedidos = pedidoDAO.getAll();
		
		for (PedidoEntity entity : listaPedidos) {
			pedidos.add(new Pedido(entity.getId(), entity.getIdProduto(), entity.getQuantidade()));
		}
 
		return pedidos;
		
	}
	
	@POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/cadastrar")	
	public PedidoEntity cadastrar(Produto produto) {
		
		PedidoEntity entity = new PedidoEntity();
		
		entity.setIdProduto(produto.getId());
		entity.setQuantidade(1);
		entity.setId(pedidoDAO.add(entity));
		
		return entity;
		
	}	
	
}
