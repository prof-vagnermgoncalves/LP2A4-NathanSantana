package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.Compra;
import model.Produto;

public class CompraDAO extends FabricaConexao{
	
	private ProdutoDAO produto = new ProdutoDAO();
	
	public int registrarCompra (Compra compra) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		int id = 0;
		int resultado = 0;
		
		try {
			for(Produto produto: compra.getProdutos()) {
				String  stmt = "insert into compras (idProduto, numeroNF) VALUES ?,?";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, produto.getId());
				pStmt.setLong(2, compra.getNumeroNF());
				
				ResultSet rs = pStmt.executeQuery();
				
				if(rs.next()) {
					id = rs.getInt(1);
					System.out.println("ID da compra registrada: " + id);
				}
				
				stmt="update produtos set qtd = ? where id = ?";
				pStmt.setInt(1, compra.getQuantidade());
				pStmt.setInt(2, produto.getId());
				
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			}		
		} catch (Exception e) {
			System.out.println("Erro ao registrar nova venda " + e.getMessage());
		}
		
		return id;
	}
	
	
}
