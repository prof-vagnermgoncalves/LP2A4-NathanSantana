package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
				String  stmt = "insert into compras (idProduto, numeroNF, quantidade) VALUES (?,?,?) returning idcompra";
				PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, produto.getId());
				pStmt.setLong(2, compra.getNumeroNF());
				pStmt.setInt(3, compra.getQuantidade());
				
				ResultSet rs = pStmt.executeQuery();
				
				if(rs.next()) {
					id = rs.getInt(1);
					System.out.println("ID da compra registrada: " + id);
				}
				super.fecharConexao();
				
				System.out.println(rs);
				
				
				int quantidadeFinal = produto.getQtd() + compra.getQuantidade();
				stmt="update produtos set qtd = ? where id = ?";
				pStmt = super.abrirConexao().prepareStatement(stmt);
				pStmt.setInt(1, quantidadeFinal);
				System.out.println(produto.getId());
				pStmt.setInt(2, produto.getId());
				
				resultado = pStmt.executeUpdate();
				super.fecharConexao();
			}		
				
		} catch (Exception e) {
			System.out.println("Erro ao registrar nova compra " + e.getMessage());
		}
		
		return id;
	}
	
	public List<Compra> recuperarComprasEProdutos (){
		List<Compra> compras = new ArrayList<Compra>();
		
		try {
			String  stmt = "SELECT * FROM compras INNER JOIN produtos ON produtos.id = idcompra";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				Compra c = new Compra();
				Produto p1 = new ProdutoDAO().recuperarProdutoPorId(rs.getInt("idproduto"));
				
				List<Produto> produtos= new ArrayList<Produto>();
				produtos.add(p1);
				
				c.setId(rs.getInt("idcompra"));
				c.setNumeroNF(rs.getLong("numeronf"));
				c.setProdutos(produtos);
				
				compras.add(c);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar compras" + e.getMessage());
		}
		
		return compras;
		
		
	}
	
	
}
