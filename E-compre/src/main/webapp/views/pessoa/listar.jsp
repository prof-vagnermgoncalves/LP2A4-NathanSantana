<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="model.Pessoa" %>
    <%@page import="java.util.Set" %>
    <%@page import="java.util.Collection"%>
    <%@page import="java.util.ArrayList"%>

<%
Collection<Pessoa> pessoas = new ArrayList<Pessoa>();
if(request.getAttribute("pessoasCadastradas") != null)
	pessoas =
		(Collection<Pessoa>) request.getAttribute("pessoasCadastradas");
%>
    
<div class="container">
	<div class="row">
		<div class="col-xl-12 d-flex flex-row">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/pessoa/cadastrar" role="button">
			Cadastrar nova pessoa
			</a>
		</div>
	</div>
</div>

<div class="row mt-3">
	<div class="col-xl-12">
		<table id="dtPessoas" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th class="th-sm">Id</th>
					<th class="th-sm">Nome</th>
					<th class="th-sm">CPF</th>
					<th class="th-sm">Sexo</th>
					<!-- <th class="th-sm">Data de nascimento</th> -->
					<th class="th-sm">Telefone</th>
					<th class="th-sm">Email</th>
				</tr>
			</thead>
			<tbody>
				<%
					
					for(Pessoa p : pessoas)
					{
						out.println("<tr>");
						
						out.println("<td>" + p.getId() + "</td>");
						out.println("<td>" + p.getNome() + "</td>");
						out.println("<td>" + p.getCpf() + "</td>");
						out.println("<td>" + p.getSexo() + "</td>");
						//out.println("<td>" + p.getDataNasc() + "</td>");
						out.println("<td>" + p.getTelefone() + "</td>");
						out.println("<td>" + p.getEmail() + "</td>");
						
						out.println("<td>");
						out.println("<a role=\"button\" class=\"btn btn-secondary\" ");
						out.println("href=\"");
						out.println(request.getContextPath());
						out.println("/pessoa/editar?idpessoa=");
						out.println(p.getId());
						out.println("\"> </a>");
						out.println("</tr>");
					}
				%>
			</tbody>
		</table>
	
	</div>

</div>