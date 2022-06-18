package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO extends FabricaConexao{

	public int criarProduto(Produto produto) {
		int id=0;
		
		try {
			String stmt = "insert into produtos (nome, preco, qtd, categoria, descricao) values (?, ?, ?, ?, ?) returning id";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setString(1, produto.getNome());
			pStmt.setDouble(2, produto.getPreco());
			pStmt.setInt(3, produto.getQtd());
			pStmt.setString(4, produto.getCategoria());
			pStmt.setString(5, produto.getDescricao());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			super.fecharConexao();
			
		}catch (Exception e){
			System.out.println("Erro ao cadastrar novo produto. " + e.getMessage());
		}
		return id;
	}
	
	public Produto recuperarProdutoPorId(int id) {
		Produto resultado = null;
		
		try {
			String stmt = "select id, nome, preco, qtd, categoria, descricao from produtos where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				resultado = new Produto();
				resultado.setId(rs.getInt("id"));
				resultado.setNome(rs.getString("nome"));
				resultado.setPreco(rs.getDouble("preco"));
				resultado.setQtd(rs.getInt("qtd"));
				resultado.setCategoria(rs.getString("categoria"));
				resultado.setDescricao(rs.getString("descricao"));
			}
			System.out.println(resultado);
			super.fecharConexao();
	
		} catch (Exception e) {
			System.out.println("Erro ao retornar o cadastro do produto com o ID: " + id + ". " + e.getMessage());
		}
		return resultado;
	}
	
	public List<Produto> recuperarProdutosPorCategoria(String category){
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			String stmt = "select id, nome, preco, qtd, categoria, descricao from produtos where categoria = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setString(1, category);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				int i = 0;
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				p.setQtd(rs.getInt("qtd"));
				p.setCategoria(rs.getString("categoria"));
				p.setDescricao(rs.getString("descricao"));
				
				produtos.add(p);
				System.out.println(produtos.get(i).getNome());
				i++;
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao retornar os produtos da categoria " + category + ". " + e.getMessage());
		}finally {
			super.fecharConexao();
		}
		
		return produtos;
	}
	
	public int editarProduto(Produto produto) {
		int resultado = 0;
		
		try {
			String stmt = "update produtos set nome = ?, preco = ?, qtd = ?, categoria = ?, descricao = ? where id = ?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(6, produto.getId());
			
			pStmt.setString(1, produto.getNome());
			pStmt.setDouble(2, produto.getPreco());
			pStmt.setInt(3, produto.getQtd());
			pStmt.setString(4, produto.getCategoria());
			pStmt.setString(5, produto.getDescricao());
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();
			
		}catch (Exception e) {
			System.out.println("Não foi possível editar o produto com o Id: " + produto.getId() + ". " + e.getMessage());
		}
		
		return resultado;
	}
	
	public int removerProduto(int id) {
		int resultado = 0;
		
		try {
			String stmt = "delete from produtos where id = ?";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, id);
			
			resultado = pStmt.executeUpdate();
			super.fecharConexao();
		} catch (Exception e) {
			System.out.println("Erro ao remover o produto com o ID: " + id + ". " + e.getMessage());
		}
		
		return resultado;
	}
	
}
