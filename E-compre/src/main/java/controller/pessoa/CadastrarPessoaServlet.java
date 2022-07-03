package controller.pessoa;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;
import model.repositorio.PessoaDAO;

import java.io.IOException;

@WebServlet({"/pessoa/cadastrar","/pessoa/cadastro","/admin/cadastrar"})
public class CadastrarPessoaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public CadastrarPessoaServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setAttribute("tituloPagina", "Cadastrar Pessoa");
		request.setAttribute("pathView", "/views/pessoa/cadastrar.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Pessoa p = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		p.setNome(request.getParameter("txtNome"));
		p.setCpf(request.getParameter("numCpf"));
		p.setSexo(request.getParameter("sexo"));
		// Data de nascimento?
		p.setTelefone(request.getParameter("txtTelefone"));
		p.setRua(request.getParameter("txtRua"));
		p.setBairro(request.getParameter("txtBairro"));
		p.setCidade(request.getParameter("txtCidade"));
		p.setEstado(request.getParameter("UF"));
		p.setEmail(request.getParameter("txtEmail"));
		p.setSenha(request.getParameter("txtSenha"));
		p.setRole("admin"); // Não pode ser nulo no BD.
		
		pessoaDAO.criarPessoa(p);
		
		request.setAttribute("tituloPagina", "Cadastrar Pessoa");
		request.setAttribute("pathView", "/views/pessoa/cadastrar.jsp");
		
		// Redireciona, novamente, para o formulário de cadastro em branco. O ideal seria direcionar para a view de listagem.
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}

















