package br.com.casa.resource;

public class Pedido {

	private int id;
	private int idProduto;
	private String nomeProduto;
	private int quantidade;

	public Pedido(int id, String nomeProduto, int quantidade) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
	}	
	
	public Pedido(int id, int idProduto, int quantidade) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}