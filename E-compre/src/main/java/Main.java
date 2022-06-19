import model.*;
import model.repositorio.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pessoa p1 = new Pessoa();
//		p1.setNome("Usu�rio de teste - editado");
//		p1.setCpf("42943512300");
//		p1.setSexo("Masculino");
//		p1.setTelefone("1126682600");
//		p1.setRua("Rua Pedro Vicente");
//		p1.setBairro("Arm�nia");
//		p1.setCidade("S�o Paulo");
//		p1.setEstado("SP");
//		p1.setEmail("usuario@teste.com");
//		p1.setSenha("12345");
//		p1.setRole("user");
//	
//	
//	PessoaDAO pessoaDAO = new PessoaDAO();
//	
//	int id = pessoaDAO.criarPessoa(p1);
//	
//	p1.setId(id);
//	
//	
//	p1.setNome("Usu�rio de teste - editado");
//	pessoaDAO.recuperarPessoa(4);
//	System.out.println("Id da pessoa inserida: " + id);
//	
//	pessoaDAO.removerPessoa(2);
//		Produto p1 = new Produto();
//		p1.setId(2);
//		p1.setNome("Kit mesas de madeira");
//		p1.setPreco(85.90);
//		p1.setQtd(10);
//		p1.setCategoria("Moveis");
//		p1.setDescricao("Kit com 2 mesas de madeira.");
//	
		ProdutoDAO produtoDAO = new ProdutoDAO();
//		
//		int id = produtoDAO.criarProduto(p1);
		//int id = p1.getId();
//		p1.setId(id);
//		System.out.println("Id do produto cadastrado: " + id);
//
//		System.out.println(p1.getId());
//		p1.setCategoria("Moveis");
//		produtoDAO.editarProduto(p1);
		
		produtoDAO.atualizarQtdProduto(1, -10);
//	
	}

}
