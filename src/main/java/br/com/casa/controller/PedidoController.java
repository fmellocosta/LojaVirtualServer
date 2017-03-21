package br.com.casa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.casa.dao.PedidoDAO;
import br.com.casa.dao.PedidoEntity;
import br.com.casa.resource.Pedido;

@Path("/pedido")
public class PedidoController {

	private final PedidoDAO pedidoDAO = new PedidoDAO();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listar")
	public List<Pedido> listar(){
 
		List<Pedido> pedidos =  new ArrayList<Pedido>();
		List<PedidoEntity> listaPedidos = pedidoDAO.getAll();
		
		for (PedidoEntity entity : listaPedidos) {
			pedidos.add(new Pedido(entity.getId(), entity.getIdProduto(), entity.getQuantidade()));
		}
 
		return pedidos;
	}
	
}
