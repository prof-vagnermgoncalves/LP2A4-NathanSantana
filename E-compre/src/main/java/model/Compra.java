package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
	private int id;
	private List<Produto> produtos = new ArrayList<Produto>();
	private Cliente cliente;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	public Compra(int id, List<Produto> produtos, Cliente cliente, Date dataCompra) {
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.dataCompra = dataCompra;
	}
	
	
	
	
	
}
