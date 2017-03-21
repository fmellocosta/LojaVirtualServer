package br.com.casa.resource;

public class Produto {

	private int id;
	private String nome;
	private Float preco;

	public Produto(int id, String nome, Float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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
	
}