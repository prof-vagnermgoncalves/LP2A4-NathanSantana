package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private int id;
	private List<Produto> produtos = new ArrayList<Produto>();
	private Pessoa pessoa;
	private Date dataCompra;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Pessoa getCliente() {
		return pessoa;
	}
	public void setCliente(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public Compra(int id, List<Produto> produtos, Pessoa pessoa, Date dataCompra) {
		this.id = id;
		this.produtos = produtos;
		this.pessoa = pessoa;
		this.dataCompra = dataCompra;
	}
	
	
	
	
	
}
