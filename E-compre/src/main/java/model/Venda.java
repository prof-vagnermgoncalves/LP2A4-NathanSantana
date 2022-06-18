package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private int id;
	private Pessoa pessoa;
	private List<Produto> produtos = new ArrayList<Produto>();
	private double valorTotal;
	private Date dataVenda = new Date();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getCliente() {
		return pessoa;
	}
	public void setCliente(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
	
}
