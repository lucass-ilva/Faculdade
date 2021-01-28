<%-- 
    Document   : cadastro
    Created on : 1/11/2020, 16:00:46
    Author     : Lucas e Victor
--%>

<%@page import="modelo.Candidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrições GMSuzano 2020</title>
        <%//recuperar a lista
            Candidato c = (Candidato) request.getAttribute("Candidato");
        %>
        <%
            String check;
            if(c.getStatus()){
                check = "checked";
            }else{
                check = "";
            }
        %> 

    </head>
    <body>
        <h1>Cadastro</h1>
        <form name="atualizar" action="CandidatoCRT">
            
            <label id="<%= c.getId() %>" hidden="">ID</label><input type="text" name="txtid" value="<%= c.getId() %>" size="5" />
            <label>Numero de Inscrição: </label><input type="text" name="txtnuminscricao" value="<%= c.getNuminscricao() %>" size="5" />
            <br><br>*Nome:  <input type="text" name="txtnome" value="<%= c.getNome() %>" size="107" />
            <br><br>*Endereço:  <input type="text" name="txtendereco" value="<%= c.getEndereco() %>" size="40"/>
            *Numero:  <input type="text" name="txtnum" value="<%= c.getNum() %>" size="5"/>
            *Bairro:  <input type="text" name="txtbairro" value="<%= c.getBairro() %>" size="30"/>
            <br><br>*CEP:  <input type="text" name="txtcep" value="<%= c.getCep() %>" />
            *RG:  <input type="text" name="txtrg" value="<%= c.getRg() %>" />
            <br><br>*Ponto de Referência:  <input type="text" name="txtreferencia" value="<%= c.getReferencia() %>" size="100"/>
            <br><br>*Telefone Fixo:  <input type="text" name="txttelfixo" value="<%= c.getTelfixo() %>" />
            *Telefone Celular:  <input type="text" name="txttelcel" value="<%= c.getTelcel() %>" />
            *Telefone Recado:  <input type="text" name="txttelrecado" value="<%= c.getTelrecado() %>" />
            <br><br>*Data Nascimento:  <input type="text" name="txtdatanasc" value="<%= c.getDatanasc() %>" />
            *Sexo:  <input type="text" name="txtsexo" value="<%= c.getSexo() %>" size="5"/>
            *Naturalidade:  <input type="text" name="txtnaturalidade" value="<%= c.getNaturalidade() %>" />
            <br><br>*Nome da Mãe:  <input type="text" name="txtnomemae" value="<%= c.getNomemae() %>" size="100"/>
            <br><br>*Nome do Pai:  <input type="text" name="txtnomepai" value="<%= c.getNomepai() %>" size="100"/>
            <br><br>*Renda Per Capita:  <input type="text" name="txtrenda" value="<%= c.getRenda() %>" size="5"/> Ex. 100.00
            <br><br>*Nota Portugues:  <input type="text" name="txtnotaport" value="<%= c.getNotaport() %>" size="5"/>
            <br><br>*Nota Matemática:  <input type="text" name="txtnotamat" value="<%= c.getNotamat() %>" size="5"/>
            <br><br>*Frequencia:  <input type="text" name="txtfreq" value="<%= c.getFreq() %>" size="5"/>
            <br><br>*Questionário:  <input type="text" name="txtquestionario" value="<%= c.getQuestionario()%>" size="5"/>
            <br><br>*Status:  
            <select name="cmbstatus">
                <option value="TRUE">Ativo</option>
                <option value="FALSE">Desativado</option>
            </select>
            
            <br><br><input type="submit" value="Atualizar" name="btn" />
            
            <h2><%= request.getAttribute("status") %> </h2>
        </form>
    </body>
</html>
