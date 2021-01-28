/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Candidato;
import util.conexao;

/**
 *
 * @author usuario
 */
public class CandidatoDAO extends conexao{
     private static final String INSERT_CANDIDATO = "INSERT INTO public.tbcandidato(can_inscricao, can_nome, can_endereco, can_numero, can_bairro, \n" +
"            can_cep, can_rg, can_pontoref, can_telefone1, can_telefone2, \n" +
"            can_telefone3, can_datanasc, can_sexo, can_naturalidade, can_escola, \n" +
"            can_nomepai, can_nomemae, can_renda, can_notaport, can_notamat, \n" +
"            can_freq, can_pontuacao)\n" +
"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
  
    private static final String SELECT_ALL = "SELECT * FROM tbcandidato ORDER BY can_pontuacao DESC";
    private static final String SELECT_ALL_NOME = "SELECT * FROM tbcandidato ORDER BY can_nome";
    private static final String SELECT_CLASS = "SELECT * FROM tbcandidato WHERE can_status = true ORDER BY can_pontuacao DESC LIMIT 400;";
    private static final String SELECT_CANDIDATO = "SELECT * FROM tbcandidato WHERE can_id = ?;";
    private static String UPDATE_CANDIDATO = "UPDATE tbcandidato SET can_inscricao=?, can_nome=?, can_endereco=?, can_numero=?, can_bairro=?, can_cep=?, can_rg=?, can_pontoref=?, can_telefone1=?, can_telefone2=?, can_telefone3=?, can_datanasc=?, can_sexo=?, can_naturalidade=?, can_nomepai=?, can_nomemae=?, can_renda=?, can_notaport=?, can_notamat=?, can_freq=?, can_questionario=?, can_status=? WHERE can_id = ?;";
    
    public boolean cadastrar(Candidato cad) throws SQLException{
        //conectar ao banco
    Connection con = null;
    con = conexao.getConexao();
        try
        {
            con.setAutoCommit(false);
            String INSERT_CANDIDATO = "INSERT INTO public.tbcandidato(can_inscricao, can_nome, can_endereco, can_numero, can_bairro, can_cep, can_rg, can_pontoref, can_telefone1, can_telefone2, can_telefone3, can_datanasc, can_sexo, can_naturalidade, can_nomepai, can_nomemae, can_renda, can_notaport, can_notamat, can_freq) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);   ";
            PreparedStatement stCandidato = con.prepareStatement(INSERT_CANDIDATO);
            stCandidato.setString(1, cad.getNuminscricao());
            stCandidato.setString(2, cad.getNome());
            stCandidato.setString(3, cad.getEndereco());
            stCandidato.setString(4, cad.getNum());
            stCandidato.setString(5, cad.getBairro());
            stCandidato.setString(6, cad.getCep());
            stCandidato.setString(7, cad.getRg());
            stCandidato.setString(8, cad.getReferencia());
            stCandidato.setString(9, cad.getTelfixo());
            stCandidato.setString(10, cad.getTelcel());
            stCandidato.setString(11, cad.getTelrecado());
            stCandidato.setString(12, cad.getDatanasc());
            stCandidato.setString(13, cad.getSexo());
            stCandidato.setString(14, cad.getNaturalidade());
            stCandidato.setString(15, cad.getNomepai());
            stCandidato.setString(16, cad.getNomemae());            
            stCandidato.setDouble(17, cad.getRenda());
            stCandidato.setDouble(18, cad.getNotaport());
            stCandidato.setDouble(19, cad.getNotamat());
            stCandidato.setInt(20, cad.getFreq());
            
            stCandidato.execute();
            con.commit();

            //retornando o sucesso
            return true;
        }
        catch (Exception e)
        {
            e.getMessage();
            return false;
        }
    }
    
    public ArrayList<Candidato> listar() throws SQLException {
        //Cria um array de obj Candidato
        ArrayList<Candidato> listaCandidato = new ArrayList<Candidato>();
        //Conexão
        Connection con = conexao.getConexao();
        //Criar comando SQL
        PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
        //Executa
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            //A cada loop
            Candidato objCandidato = new Candidato();
            objCandidato.setId(rs.getInt("can_id"));
            objCandidato.setNuminscricao(rs.getString("can_inscricao"));
            objCandidato.setNome(rs.getString("can_nome"));
            objCandidato.setEndereco(rs.getString("can_endereco"));
            objCandidato.setNum(rs.getString("can_numero"));
            objCandidato.setBairro(rs.getString("can_bairro"));
            objCandidato.setCep(rs.getString("can_cep"));
            objCandidato.setRg(rs.getString("can_rg"));
            objCandidato.setReferencia(rs.getString("can_pontoref"));
            objCandidato.setTelfixo(rs.getString("can_telefone1"));
            objCandidato.setTelcel(rs.getString("can_telefone2"));
            objCandidato.setTelrecado(rs.getString("can_telefone3"));
            objCandidato.setDatanasc(rs.getString("can_datanasc"));
            objCandidato.setSexo(rs.getString("can_sexo"));
            objCandidato.setNaturalidade(rs.getString("can_naturalidade"));
            objCandidato.setNomepai(rs.getString("can_nomepai"));
            objCandidato.setNomemae(rs.getString("can_nomemae"));
            objCandidato.setRenda(rs.getDouble("can_renda"));
            objCandidato.setNotaport(rs.getDouble("can_notaport"));
            objCandidato.setNotamat(rs.getDouble("can_notamat"));
            objCandidato.setFreq(rs.getInt("can_freq"));
            objCandidato.setPontuacao(rs.getInt("can_pontuacao"));
            objCandidato.setQuestionario(rs.getInt("can_questionario"));
            objCandidato.setPreclassificacao(rs.getInt("can_preclassificacao"));
            objCandidato.setClassificacao(rs.getInt("can_classificacao"));
            objCandidato.setStatus(rs.getBoolean("can_status"));
            
            //add na lista
            listaCandidato.add(objCandidato);
        }
        return listaCandidato;
    }
    
    public ArrayList<Candidato> listarPorNome() throws SQLException {
        //Cria um array de obj Candidato
        ArrayList<Candidato> listaCandidato = new ArrayList<Candidato>();
        //Conexão
        Connection con = conexao.getConexao();
        //Criar comando SQL
        PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_NOME);
        //Executa
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            //A cada loop
            Candidato objCandidato = new Candidato();
            objCandidato.setId(rs.getInt("can_id"));
            objCandidato.setNuminscricao(rs.getString("can_inscricao"));
            objCandidato.setNome(rs.getString("can_nome"));
            objCandidato.setEndereco(rs.getString("can_endereco"));
            objCandidato.setNum(rs.getString("can_numero"));
            objCandidato.setBairro(rs.getString("can_bairro"));
            objCandidato.setCep(rs.getString("can_cep"));
            objCandidato.setRg(rs.getString("can_rg"));
            objCandidato.setReferencia(rs.getString("can_pontoref"));
            objCandidato.setTelfixo(rs.getString("can_telefone1"));
            objCandidato.setTelcel(rs.getString("can_telefone2"));
            objCandidato.setTelrecado(rs.getString("can_telefone3"));
            objCandidato.setDatanasc(rs.getString("can_datanasc"));
            objCandidato.setSexo(rs.getString("can_sexo"));
            objCandidato.setNaturalidade(rs.getString("can_naturalidade"));
            objCandidato.setNomepai(rs.getString("can_nomepai"));
            objCandidato.setNomemae(rs.getString("can_nomemae"));
            objCandidato.setRenda(rs.getDouble("can_renda"));
            objCandidato.setNotaport(rs.getDouble("can_notaport"));
            objCandidato.setNotamat(rs.getDouble("can_notamat"));
            objCandidato.setFreq(rs.getInt("can_freq"));
            objCandidato.setPontuacao(rs.getInt("can_pontuacao"));
            objCandidato.setQuestionario(rs.getInt("can_questionario"));
            objCandidato.setPreclassificacao(rs.getInt("can_preclassificacao"));
            objCandidato.setClassificacao(rs.getInt("can_classificacao"));
            objCandidato.setStatus(rs.getBoolean("can_status"));
            
            //add na lista
            listaCandidato.add(objCandidato);
        }
        return listaCandidato;
    }

    public ArrayList<Candidato> listarClassificados() throws SQLException {
        //Cria um array de obj Candidato
        ArrayList<Candidato> listaCandidato = new ArrayList<Candidato>();
        //Conexão
        Connection con = conexao.getConexao();
        //Criar comando SQL
        PreparedStatement pstmt = con.prepareStatement(SELECT_CLASS);
        //Executa
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            //A cada loop
            Candidato objCandidato = new Candidato();
            objCandidato.setId(rs.getInt("can_id"));
            objCandidato.setNuminscricao(rs.getString("can_inscricao"));
            objCandidato.setNome(rs.getString("can_nome"));
            objCandidato.setEndereco(rs.getString("can_endereco"));
            objCandidato.setNum(rs.getString("can_numero"));
            objCandidato.setBairro(rs.getString("can_bairro"));
            objCandidato.setCep(rs.getString("can_cep"));
            objCandidato.setRg(rs.getString("can_rg"));
            objCandidato.setReferencia(rs.getString("can_pontoref"));
            objCandidato.setTelfixo(rs.getString("can_telefone1"));
            objCandidato.setTelcel(rs.getString("can_telefone2"));
            objCandidato.setTelrecado(rs.getString("can_telefone3"));
            objCandidato.setDatanasc(rs.getString("can_datanasc"));
            objCandidato.setSexo(rs.getString("can_sexo"));
            objCandidato.setNaturalidade(rs.getString("can_naturalidade"));
            objCandidato.setNomepai(rs.getString("can_nomepai"));
            objCandidato.setNomemae(rs.getString("can_nomemae"));
            objCandidato.setRenda(rs.getDouble("can_renda"));
            objCandidato.setNotaport(rs.getDouble("can_notaport"));
            objCandidato.setNotamat(rs.getDouble("can_notamat"));
            objCandidato.setFreq(rs.getInt("can_freq"));
            objCandidato.setPontuacao(rs.getInt("can_pontuacao"));
            objCandidato.setQuestionario(rs.getInt("can_questionario"));
            objCandidato.setPreclassificacao(rs.getInt("can_preclassificacao"));
            objCandidato.setClassificacao(rs.getInt("can_classificacao"));
            objCandidato.setStatus(rs.getBoolean("can_status"));
            //add na lista
            listaCandidato.add(objCandidato);
        }
        return listaCandidato;
    }
    
    public Candidato buscar(Candidato can) throws SQLException {
        
        Connection con = conexao.getConexao(); //Abrir Conexão
        PreparedStatement pstmt = con.prepareStatement(SELECT_CANDIDATO); //Criar comando SQL
        pstmt.setInt(1, can.getId());
        ResultSet rs = pstmt.executeQuery(); //Executar comando SQL
        rs.next();
        //Popular objeto candidato
        can.setId(rs.getInt("can_id"));
        can.setNuminscricao(rs.getString("can_inscricao"));
        can.setNome(rs.getString("can_nome"));
        can.setEndereco(rs.getString("can_endereco"));
        can.setNum(rs.getString("can_numero"));
        can.setBairro(rs.getString("can_bairro"));
        can.setCep(rs.getString("can_cep"));
        can.setRg(rs.getString("can_rg"));
        can.setReferencia(rs.getString("can_pontoref"));
        can.setTelfixo(rs.getString("can_telefone1"));
        can.setTelcel(rs.getString("can_telefone2"));
        can.setTelrecado(rs.getString("can_telefone3"));
        can.setDatanasc(rs.getString("can_datanasc"));
        can.setSexo(rs.getString("can_sexo"));
        can.setNaturalidade(rs.getString("can_naturalidade"));
        can.setNomepai(rs.getString("can_nomepai"));
        can.setNomemae(rs.getString("can_nomemae"));
        can.setRenda(rs.getDouble("can_renda"));
        can.setNotaport(rs.getDouble("can_notaport"));
        can.setNotamat(rs.getDouble("can_notamat"));
        can.setFreq(rs.getInt("can_freq"));
        can.setPontuacao(rs.getInt("can_pontuacao"));
        can.setQuestionario(rs.getInt("can_questionario"));
        can.setPreclassificacao(rs.getInt("can_preclassificacao"));
        can.setClassificacao(rs.getInt("can_classificacao"));
        can.setStatus(rs.getBoolean("can_status"));
    
        return can;
    }

    public boolean atualizar(Candidato cad) throws SQLException{
        //conectar ao banco
    Connection con = null;
    con = conexao.getConexao();
        try
        {
            con.setAutoCommit(false);
            String UPDATE_CANDIDATO = "UPDATE tbcandidato SET can_inscricao=?, can_nome=?, can_endereco=?, can_numero=?, can_bairro=?, can_cep=?, can_rg=?, can_pontoref=?, can_telefone1=?, can_telefone2=?, can_telefone3=?, can_datanasc=?, can_sexo=?, can_naturalidade=?, can_nomepai=?, can_nomemae=?, can_renda=?, can_notaport=?, can_notamat=?, can_freq=?, can_questionario=?, can_status=? WHERE can_id = ?;";
            PreparedStatement stCandidato = con.prepareStatement(UPDATE_CANDIDATO);
            stCandidato.setString(1, cad.getNuminscricao());    //can_inscricao=?
            stCandidato.setString(2, cad.getNome());            //can_nome=?
            stCandidato.setString(3, cad.getEndereco());        //can_endereco=?
            stCandidato.setString(4, cad.getNum());             //can_numero=? 
            stCandidato.setString(5, cad.getBairro());          //can_bairro=?
            stCandidato.setString(6, cad.getCep());             //can_cep=?, 
            stCandidato.setString(7, cad.getRg());              //can_rg=?
            stCandidato.setString(8, cad.getReferencia());      //can_pontoref=?
            stCandidato.setString(9, cad.getTelfixo());         //can_telefone1=?
            stCandidato.setString(10, cad.getTelcel());         //can_telefone2=?
            stCandidato.setString(11, cad.getTelrecado());      //can_telefone3=?
            stCandidato.setString(12, cad.getDatanasc());       //can_datanasc=?
            stCandidato.setString(13, cad.getSexo());           //can_sexo=?
            stCandidato.setString(14, cad.getNaturalidade());   //can_naturalidade=?
            stCandidato.setString(15, cad.getNomepai());        //can_nomepai=?
            stCandidato.setString(16, cad.getNomemae());        //can_nomemae=? 
            stCandidato.setDouble(17, cad.getRenda());          //can_renda=?
            stCandidato.setDouble(18, cad.getNotaport());       //can_notaport=?
            stCandidato.setDouble(19, cad.getNotamat());        //can_notamat=?
            stCandidato.setInt(20, cad.getFreq());              //can_freq=?
            stCandidato.setDouble(21, cad.getQuestionario());   //can_questionario=?
            stCandidato.setBoolean(22, cad.getStatus());        //can_status=? 
            stCandidato.setInt(23, cad.getId());                //can_id = ?
            
            stCandidato.execute();
            con.commit();

            //retornando o sucesso
            return true;
        }
        catch (Exception e)
        {
            e.getMessage();
            return false;
        }
    }
}

