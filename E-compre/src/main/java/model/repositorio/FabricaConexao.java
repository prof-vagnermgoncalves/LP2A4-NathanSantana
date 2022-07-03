package model.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao
{
	protected Connection conn;
	
	public Connection abrirConexao()
	{
		try
		{
			if(this.conn == null)
			{
				Class.forName("org.postgresql.Driver");
				
				String url = "jdbc:postgresql://localhost/ecommercemvc";
				
				Properties props = new Properties();
				props.setProperty("user", "postgres");
				props.setProperty("password", "postgres");
				props.setProperty("ssl", "false");
				
				this.conn =  DriverManager.getConnection(url, props);
				
				System.out.println("Conexao aberta!");
			}
			else {
				System.out.println("Conexao ja esta aberta!");
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao criar conexao! " + e.getMessage());
		}
		
		return this.conn;
	}
	
	public void fecharConexao() {
		try {
			if(this.conn != null) {
				this.conn.close();
				this.conn = null;
				System.out.println("Conexao fechada!");
			}
			else
			{
				System.out.println("Conexao nao existe!");
			}
		}
		catch (Exception e) {
			System.out.println("Erro ao fechar conexao! " + e.getMessage());
		}
	}
	
}
