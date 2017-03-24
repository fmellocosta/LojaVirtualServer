package br.com.casa.resource;

public class Pedido {

	private int id;
	private int idProduto;
	private String nomeProduto;
	private int quantidade;
	private String nome;
	private int cartao;

	public Pedido() {
		
	}
	
	public Pedido(int id, int idProduto, int quantidade) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}	
	
	public Pedido(int id, String nomeProduto, int quantidade, String nome, int cartao) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.nome = nome;
		this.cartao = cartao;
	}	
	
	public Pedido(int id, int idProduto, int quantidade, String nome, int cartao) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.nome = nome;
		this.cartao = cartao;		
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCartao() {
		return cartao;
	}

	public void setCartao(int cartao) {
		this.cartao = cartao;
	}
	
}