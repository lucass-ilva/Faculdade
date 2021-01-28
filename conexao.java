/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author Usuario
 */
public class conexao {

    //não precisa instanciar o objeto
    public static Connection getConexao()
    {
        /*
            Selecionar base de dados:
            0 - Banco de Dados Servidor
            1 - Bando de Dados Local
        */
        int base = 1; 
        Connection conexao = null;
        if (base == 0)
        {
        String usuario = "postgres";
        String senha = "Kkk095757";
        String banco = "postgres";
        try
         {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/inscricao"+ banco, usuario, senha);
         }
         catch (Exception e)
         {
             e.printStackTrace();
             return null;
         }
        }
        else
        {
            if (base == 1){
                String usuario = "postgres";
                String senha = "Kkk095757";
                String banco = "postgres";
                try
                {
                    Class.forName("org.postgresql.Driver");
                    conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/"+ banco, usuario, senha);
                 }
                 catch (Exception e)
                 {
                     e.printStackTrace();
                     return null;
                 }
            }
        }
        return(conexao);
    }

    public static PreparedStatement prepareStatement(String SELECT_ALL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
