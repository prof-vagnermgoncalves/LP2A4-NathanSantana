package model;

public class Produto {
	private String nome;
    private int id;
    private double preco;
    private int qtd;
    private String categoria;
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	public Produto(String nome, int id, double preco, int qtd, String categoria) {
		super();
		this.nome = nome;
		this.id = id;
		this.preco = preco;
		this.qtd = qtd;
		this.categoria = categoria;
	}
    
	
	
    
}
