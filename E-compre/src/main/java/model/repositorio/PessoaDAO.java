package model.repositorio;

import java.sql.PreparedStatement;

public class PessoaDAO extends FabricaConexao{

	public int criarPessoa(Pessoa pessoa) {
		int id = 0;
		
		try {
			String stmt = "insert into pessoas (nome, cpf, sexo, telefone, rua, bairro, cidade, estado, email, senha, role) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, user) returning id";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			
			
		}
	}
}
