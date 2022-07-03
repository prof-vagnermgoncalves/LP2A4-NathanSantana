<%@page import="model.Pessoa"%>

<%
Pessoa p = new Pessoa();

if(request.getAttribute("pessoa") != null)
    p = (Pessoa) request.getAttribute("pessoa");
%>

<form method="POST"
      action="${pageContext.request.contextPath}/pessoa/editar">
    
    <input type="hidden" name="hidId" value="<%= p.getId() %>" >
    
    <p>
        <label for="txtNome">Nome:</label>
        <input type="text" name="txtNome" value="<%= p.getNome() %>" >
    </p>
    
    <p>
        <label for="numCpf">CPF:</label>
        <input type="text" name="numCpf" value="<%= p.getCpf() %>" >
    </p>
    
    <label for="sexo">Sexo</label>
    
    
    <!-- Implementar logica para, a partir do valor de p.getSexo(), trazer a opcao adequada ja selecionada no HTML final -->
    <select name="sexo" id="sexo">
      <option value="Masculino">Masculino</option>
      <option value="Feminino">Feminino</option>
      <option value="Diadico">Diádico</option>
      <option value="Intersexo">Intersexo</option>
      <option value="Altersexo">Altersexo</option>
    </select>
    
    <p>
        <label for="txtTelefone">Telefone:</label>
        <input type="text" name="txtTelefone" value="<%= p.getTelefone() %>">
    </p>
    
    <p>
        <label for="txtRua">Rua:</label>
        <input type="text" name="txtRua" value="<%= p.getRua() %>">
    </p>
    
    <p>
        <label for="txtBairro">Bairro:</label>
        <input type="text" name="txtBairro" value="<%= p.getBairro() %>">
    </p>
    
    <p>
        <label for="txtCidade">Cidade:</label>
        <input type="text" name="txtCidade" value="<%= p.getCidade() %>">
    </p>
    
    <!-- Implementar logica para, a partir do valor de p.getEstado(), trazer a opcao adequada ja selecionada no HTML final -->
    <label for="UF">Estado:</label>
    <select id="UF" name="UF">
        <option value="">Selecione</option>
        <option value="AC">AC</option>
        <option value="AL">AL</option>
        <option value="AP">AP</option>
        <option value="AM">AM</option>
        <option value="BA">BA</option>
        <option value="CE">CE</option>
        <option value="DF">DF</option>
        <option value="ES">ES</option>
        <option value="GO">GO</option>
        <option value="MA">MA</option>
        <option value="MS">MS</option>
        <option value="MT">MT</option>
        <option value="MG">MG</option>
        <option value="PA">PA</option>
        <option value="PB">PB</option>
        <option value="PR">PR</option>
        <option value="PE">PE</option>
        <option value="PI">PI</option>
        <option value="RJ">RJ</option>
        <option value="RN">RN</option>
        <option value="RS">RS</option>
        <option value="RO">RO</option>
        <option value="RR">RR</option>
        <option value="SC">SC</option>
        <option value="SP">SP</option>
        <option value="SE">SE</option>
        <option value="TO">TO</option>
    </select>
    
    
    <p>
        <label for="txtEmail">Email:</label>
        <input type="text" name="txtEmail" value="<%= p.getEmail() %>">
    </p>
    
    <p>
        <label for="txtSenha">Senha:</label>
        <input type="text" name="txtSenha" value="<%= p.getSenha() %>">
    </p>
    
    <p>
        <input type="submit" value="Enviar">
    </p>
</form>