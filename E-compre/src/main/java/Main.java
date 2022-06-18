import model.Pessoa;
import model.repositorio.PessoaDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa();
		p1.setNome("Usuário de teste");
		p1.setCpf("42943512300");
		p1.setSexo("Masculino");
		p1.setTelefone("1126682600");
		p1.setRua("Rua Pedro Vicente");
		p1.setBairro("Armênia");
		p1.setCidade("São Paulo");
		p1.setEstado("SP");
		p1.setEmail("usuario@teste.com");
		p1.setSenha("12345");
		p1.setRole("user");
	
	
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	int id = pessoaDAO.criarPessoa(p1);
	
	p1.setId(id);
	
	System.out.println("Id da pessoa inserida: " + id);
	
	}

}
