package br.com.casa.resource;

public class Produto {

	private int id;
	private String nome;
	private Float preco;
	private String imagem;
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, Float preco, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.setImagem(imagem);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}	
	
}