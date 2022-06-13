package model.repositorio;

import java.sql.*;
import java.util.ArrayList;

import model.Item;

public class ItemDAO extends FabricaConexao {	

	public int criarItem (Item item)
	{
		int id = 0;
		
		try {
			String stmt = "insert into itens (titulo,  descricao, estado) values (?, ?, ?) returning id";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			pStmt.setString(1, item.getTitulo());
			pStmt.setString(2, item.getDescricao());
			pStmt.setBoolean(3, item.getEstado());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			super.fecharConexao();
		}
		catch (Exception e) {
			System.out.println("Erro ao tentar inserir um novo cadastro! " + e.getMessage());
		}
		
		return id;
		
	}
	
//	public ArrayList<Item> recuperarItens()
//	{
//		
//	}
//	
//	public Item recuperarItemPorId(int id)
//	{
//		
//	}
//	
//	public int editarItem(Item item)
//	{
//		
//	}
//	
//	public int removerItem(int id)
//	{
//		
//	}
}
