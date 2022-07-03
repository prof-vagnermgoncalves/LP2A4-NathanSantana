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

@WebServlet({"/pessoa/editar","/admin/editar","/user/editar"})
public class EditarPessoaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    public EditarPessoaServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException
    {
		
		int idPessoa=0;
		Pessoa p = null;
		String idInformado = request.getParameter("id");
		
		if (idInformado != null)
		{
			try
			{
				idPessoa = Integer.parseInt(idInformado);
			}
			catch (Exception e)
			{
				System.out.println("O ID informado e invalido.");
			}
		}
		
		PessoaDAO pessoa = new PessoaDAO();
		
		p = pessoa.recuperarPessoa(idPessoa);
		
		request.setAttribute("tituloPagina", "Editar Pessoa");
		request.setAttribute("pathView", "/views/pessoa/editar.jsp");
		request.setAttribute("pessoa", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Pessoa p = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		p.setId(Integer.parseInt(request.getParameter("hidId").trim()));
		
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
		
		pessoaDAO.editarPessoa(p);
		
		request.setAttribute("tituloPagina", "Editar Pessoa");
		request.setAttribute("pathView", "/views/pessoa/editar.jsp");
		request.setAttribute("pessoa", p);
		
		// Redireciona, novamente, para o formulário de edição. O ideal seria direcionar para a view de listagem.
		RequestDispatcher rd = request.getRequestDispatcher("/template.jsp");
		rd.forward(request, response);
	}

}
