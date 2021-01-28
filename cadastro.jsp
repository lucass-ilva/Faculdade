<%-- 
    Document   : cadastro
    Created on : 1/11/2020, 18:00:46
    Author     : Lucas e Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscrições GMSuzano 2020</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <form name="cadastrar" action="CandidatoCRT">
            *Numero de Inscrição:  <input type="text" name="txtnuminscricao" value="" size="5" />
            <br><br>*Nome:  <input type="text" name="txtnome" value="" size="107" />
            <br><br>*Endereço:  <input type="text" name="txtendereco" value="" size="40"/>
            *Numero:  <input type="text" name="txtnum" value="" size="5"/>
            *Bairro:  <input type="text" name="txtbairro" value="" size="30"/>
            <br><br>*CEP:  <input type="text" name="txtcep" value="" />
            *RG:  <input type="text" name="txtrg" value="" />
            <br><br>*Ponto de Referência:  <input type="text" name="txtreferencia" value="" size="100"/>
            <br><br>*Telefone Fixo:  <input type="text" name="txttelfixo" value="0" />
            *Telefone Celular:  <input type="text" name="txttelcel" value="0" />
            *Telefone Recado:  <input type="text" name="txttelrecado" value="0" />
            <br><br>*Data Nascimento:  <input type="text" name="txtdatanasc" value="" />
            *Sexo:  <input type="text" name="txtsexo" value="" size="5"/>
            *Naturalidade:  <input type="text" name="txtnaturalidade" value="Suzano" />
            <br><br>*Nome da Mãe:  <input type="text" name="txtnomemae" value="" size="100"/>
            <br><br>*Nome do Pai:  <input type="text" name="txtnomepai" value="" size="100"/>
            <br><br>*Renda Per Capita:  <input type="text" name="txtrenda" value="" size="5"/> Ex. 100.000
            <br><br>*Como soube da Guarda Mirim:  <input type="text" name="txtfeedback" value="GM" />
            <br><br>*Nota Portugues:  <input type="text" name="txtnotaport" value="" size="5"/>
            <br><br>*Nota Matemática:  <input type="text" name="txtnotamat" value="" size="5"/>
            <br><br>*Frequencia:  <input type="text" name="txtfreq" value="" size="5"/>
            
            <br><br><input type="submit" value="Cadastrar" name="btn" />
            
            <h2><%= request.getAttribute("status") %> </h2>
        </form>
    </body>
</html>
