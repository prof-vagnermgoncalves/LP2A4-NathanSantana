package model;

public class Produto {
	private int id;
	private String nome;
    private double preco;
    private int qtd;
    private String categoria;
    private String descricao;
    
    
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
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Produto(String nome, int id, double preco, int qtd, String categoria, String descricao) {
		super();
		this.nome = nome;
		this.id = id;
		this.preco = preco;
		this.qtd = qtd;
		this.categoria = categoria;
		this.descricao = descricao;
	}
	
	public Produto(){
		
	}
    
	
	
    
}
