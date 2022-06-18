package model.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import model.Venda;

public class VendaDAO extends FabricaConexao{

	private PessoaDAO pessoa = new PessoaDAO();
	private ProdutoDAO produto = new ProdutoDAO();
	
	public int registrarVenda(Venda venda) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		int id = 0;
		
		try {
			String stmt = "insert into vendas (idPessoa, valorTotal, dataVenda)";
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			pStmt.setInt(1, venda.getPessoa().getId());
			pStmt.setDouble(2, venda.getValorTotal());
			String data = dateFormat.format(venda.getDataVenda());
			pStmt.setString(3, data);
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt(1);
			}
			
			super.fecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
