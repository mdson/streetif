/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.controllers.servlets;

import com.devcaotics.model.negocios.Lutador;
import com.devcaotics.model.repositorios.RepositorioLutador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MaD
 */
@WebServlet(name = "LutadorServletJsp", urlPatterns = {"/LutadorServletJsp"})
public class LutadorServletJsp extends HttpServlet {

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
        
        String operacao = request.getParameter("op");
        String id = request.getParameter("id");
        
        
        if(id != null){
            int i = Integer.parseInt(id);
            Lutador l = RepositorioLutador.getCurrentInstance().ler(i);
            request.setAttribute("lutador", l);
        }
        
        
        if(operacao != null && operacao.equals("visualizar")){
            Lutador l = RepositorioLutador.getCurrentInstance().ler(Integer.parseInt(id));
            request.setAttribute("lutador", l);
        }
        
        if(operacao != null && operacao.equals("fechamento")){
            operacao = null;
            response.sendRedirect("LutadorServletJsp");
            return;
        }
        
        List<Lutador> lutadores = RepositorioLutador.getCurrentInstance().lerTudo();
        request.setAttribute("lutadores", lutadores);
        request.getRequestDispatcher("/lutadores.jsp").forward(request, response);
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
        
        String nome = request.getParameter("nome");
        String apelido = request.getParameter("apelido");
        String senha = request.getParameter("senha");
        double peso = Double.parseDouble(request.getParameter("peso"));
        double altura = Double.parseDouble(request.getParameter("altura"));
        
        Date data = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            data = formato.parse(request.getParameter("nascimento"));
        } catch (ParseException ex) {
            Logger.getLogger(LutadorServletJsp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String maoprincipal = request.getParameter("maoprincipal");
        String curso = request.getParameter("curso");
        String estilomarcial = request.getParameter("estilomarcial");
        String contatoemergencial = request.getParameter("contatoemergencial");
        
        Lutador l = new Lutador();
        
        l.setNome(nome);
        l.setApelido(apelido);
        l.setSenha(senha);
        l.setPeso(peso);
        l.setAltura(altura);
        l.setNascimento(data);
        
        if(maoprincipal.equalsIgnoreCase("destro")){
            l.setDestro(true);
        }else{
            l.setDestro(false);
        }
        
        l.setCurso(curso);
        l.setArtMarcial(estilomarcial);
        l.setContatoEmergencia(contatoemergencial);
        
        String operacao = request.getParameter("op");
        HttpSession session = request.getSession();
        
        if(operacao == null){
            RepositorioLutador.getCurrentInstance().inserir(l);
        }else if(operacao.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));  
            l.setId(id);
            RepositorioLutador.getCurrentInstance().alterar(l);
            session.setAttribute("msg", "Cadastro do lutador "+apelido+" alterado com sucesso!");
            response.sendRedirect("LutadorServletJsp");
            return;
        }

        
        session.setAttribute("msg", "Lutador "+apelido+" cadastrado com sucesso!");
        response.sendRedirect("LutadorServletJsp");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doDelete(request, response); //To change body of generated methods, choose Tools | Templates.
        
        HttpSession session = request.getSession();
        String id = request.getParameter("id");

        session.setAttribute("msg", "Cadastro do lutador com ID "+id+" deletado com sucesso!");
        RepositorioLutador.getCurrentInstance().remover(Integer.parseInt(id));
        
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
