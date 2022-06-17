package model;

public class Produto {
	private String nome;
    private int id;
    private double preco;
    private double qtd;
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
	public double getQtd() {
		return qtd;
	}
	public void setQtd(double qtd) {
		this.qtd = qtd;
	}
	
	
	
	public Produto(String nome, int id, double preco, double qtd) {
		super();
		this.nome = nome;
		this.id = id;
		this.preco = preco;
		this.qtd = qtd;
	}
    
	
	
    
}
