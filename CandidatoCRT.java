/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CandidatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Candidato;

/**
 *
 * @author usuario
 */
public class CandidatoCRT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            
            //int op = Integer.parseInt(request.getParameter("btn"));
            
            switch(request.getParameter("btn")){
                //Cadastrar Novo candidato                
                case "Cadastrar":
                    try{
                        String status = null;
                        Candidato cad = new Candidato();
                        cad.setNuminscricao(request.getParameter("txtnuminscricao"));
                        cad.setNome(request.getParameter("txtnome"));
                        cad.setEndereco(request.getParameter("txtendereco"));
                        cad.setNum(request.getParameter("txtnum"));
                        cad.setBairro(request.getParameter("txtbairro"));
                        cad.setCep(request.getParameter("txtcep"));
                        cad.setRg(request.getParameter("txtrg"));
                        cad.setReferencia(request.getParameter("txtreferencia"));
                        cad.setTelfixo(request.getParameter("txttelfixo"));
                        cad.setTelcel(request.getParameter("txttelcel"));
                        cad.setTelrecado(request.getParameter("txttelrecado"));
                        cad.setDatanasc(request.getParameter("txtdatanasc"));
                        cad.setSexo(request.getParameter("txtsexo"));
                        cad.setNaturalidade(request.getParameter("txtnaturalidade"));
                        cad.setNomemae(request.getParameter("txtnomemae"));
                        cad.setNomepai(request.getParameter("txtnomepai"));
                        cad.setRenda(Double.parseDouble(request.getParameter("txtrenda")));
                        cad.setFeedback(request.getParameter("txtfeedback"));
                        cad.setNotaport(Double.parseDouble(request.getParameter("txtnotaport")));
                        cad.setNotamat(Double.parseDouble(request.getParameter("txtnotamat")));
                        cad.setFreq(Integer.parseInt(request.getParameter("txtfreq")));   
                        //efetuar a gravação
                        CandidatoDAO obj = new CandidatoDAO();
                        if (obj.cadastrar(cad)){
                            status = "Sucesso";
                        }else{
                            status = "Falha";
                    }
                    request.setAttribute("status",status);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cadastro.jsp");
                    dispatcher.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "Atualizar":
                    try{
                        String status1 = null;
                        Candidato cad = new Candidato();
                        cad.setNuminscricao(request.getParameter("txtnuminscricao"));                       // Get Inscrção
                        cad.setNome(request.getParameter("txtnome"));                                       // Get Nome
                        cad.setEndereco(request.getParameter("txtendereco"));                               // Get Endereço
                        cad.setNum(request.getParameter("txtnum"));                                         // Get Numero
                        cad.setBairro(request.getParameter("txtbairro"));                                   // Get Bairro
                        cad.setCep(request.getParameter("txtcep"));                                         // Get CEP
                        cad.setRg(request.getParameter("txtrg"));                                           // Get RG
                        cad.setReferencia(request.getParameter("txtreferencia"));                           // Get Referencia
                        cad.setTelfixo(request.getParameter("txttelfixo"));                                 // Get Tel. Fixo
                        cad.setTelcel(request.getParameter("txttelcel"));                                   // Get Tel. Celular
                        cad.setTelrecado(request.getParameter("txttelrecado"));                             // Get Tel. Recado
                        cad.setDatanasc(request.getParameter("txtdatanasc"));                               // Get Data de Nascimento
                        cad.setSexo(request.getParameter("txtsexo"));                                       // Get Sexo
                        cad.setNaturalidade(request.getParameter("txtnaturalidade"));                       // Get Naturalidade
                        cad.setNomemae(request.getParameter("txtnomemae"));                                 // Get Nome Mãe
                        cad.setNomepai(request.getParameter("txtnomepai"));                                 // Get Nome Pai
                        cad.setRenda(Double.parseDouble(request.getParameter("txtrenda")));                 // Get Renda
                        cad.setNotaport(Double.parseDouble(request.getParameter("txtnotaport")));           // Get Nota Portugues
                        cad.setNotamat(Double.parseDouble(request.getParameter("txtnotamat")));             // Get Nota Matematica
                        cad.setFreq(Integer.parseInt(request.getParameter("txtfreq")));                     // Get Frequencia
                        cad.setQuestionario(Double.parseDouble(request.getParameter("txtquestionario")));   // Get Questionario
                        cad.setStatus(Boolean.parseBoolean(request.getParameter("cmbstatus")));             // Get Status
                        cad.setId(Integer.parseInt(request.getParameter("txtid")));                         // Get Id

                        
                        CandidatoDAO obj = new CandidatoDAO(); //Criar obj CandidatoDAO
                        if (obj.atualizar(cad)){        // Executar o metodo ATUALIZAR e verificar se o retorno é TRUE
                            status1 = "Sucesso";
                        }else{
                            status1 = "Falha";
                    }
                    request.setAttribute("status",status1);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CandidatoCRT?btn=Listar");
                    dispatcher.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;
                //Listar Todos os Candidatos    
                case "Geral" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listar();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "Classificados" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listarClassificados();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break; 
                case "Pedagogico" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listarClassificados();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("listarPedagogia.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break; 
                case "Psico" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listarClassificados();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("listarPsico.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break; 
                case "Social" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listarClassificados();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("listarSocial.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;
                //Listar Todos os Candidatos    
                case "Listar" :
                    try{
                    //Criar objero CandidatoDAO
                    CandidatoDAO objDAO = new CandidatoDAO();
                    //Executar o método listar
                    ArrayList<Candidato> candidato = objDAO.listarPorNome();
                    //Add a lista no objeto para o jsp
                    request.setAttribute("liscaCandidato",candidato);
                    //Encaminhar o request para o jsp
                    RequestDispatcher rd = request.getRequestDispatcher("alterar.jsp");
                    rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;
                case "Buscar" :
                    try{
                        Candidato objcand = new Candidato();
                        objcand.setId(Integer.parseInt(request.getParameter("id")));
                        CandidatoDAO objDAO = new CandidatoDAO(); //Criar objero CandidatoDAO
                        objcand = objDAO.buscar(objcand);//Executar o método listar
                        request.setAttribute("Candidato",objcand);//Add a lista no objeto para o jsp
                        RequestDispatcher rd = request.getRequestDispatcher("atualizarCandidato.jsp");//Encaminhar o request para o jsp
                        rd.forward(request, response);
                    }
                    catch(Exception e){
                        request.setAttribute("erro",e);
                        RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
                        rd.forward(request, response);
                    }
                    break;

            }
        }
        catch(Exception e){
            //
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoCRT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoCRT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
