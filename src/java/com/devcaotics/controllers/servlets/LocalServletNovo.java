/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.controllers.servlets;

import com.devcaotics.model.negocios.Local;
import com.devcaotics.model.repositorios.RepositorioLocalMemo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "LocalServletNovo", urlPatterns = {"/LocalServletNovo"})
public class LocalServletNovo extends HttpServlet {

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
        
        if(operacao != null && operacao.equals("update")){
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            Local l = RepositorioLocalMemo.getCurrentInstance().ler(id);
            
            request.setAttribute("local", l);
            
            request.getRequestDispatcher("/atualizaLocalNovo.jsp").forward(request, response);
            
            return;
            
        }
        
        if(operacao!=null && operacao.equals("delete")){
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            RepositorioLocalMemo.getCurrentInstance().remover(id);
            
        }
        
        List<Local> locais = RepositorioLocalMemo
                .getCurrentInstance().lerTudo();
        
        request.setAttribute("locais", locais);
        
        request.getRequestDispatcher("/locaisNovo.jsp")
                .forward(request, response);
        
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
        
        String apelido = request.getParameter("apelido");
        String endereco = request.getParameter("endereco");
        int capacidade = Integer.parseInt(request.getParameter("capacidade"));
        
        Local l = new Local();
        
        l.setApelido(apelido);
        l.setEndereco(endereco);
        l.setCapacidade(capacidade);
        
        String operacao = request.getParameter("op");
        
        if(operacao != null && operacao.equals("update")){
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            l.setId(id);
            
            RepositorioLocalMemo.getCurrentInstance().alterar(l);
            
            response.sendRedirect("LocalServletNovo?msg=Local%20"+apelido+"%20alterado%20com%20sucesso!");
            
            return;
            
        }
        
        RepositorioLocalMemo.getCurrentInstance().inserir(l);
        
        request.setAttribute("msg", "Local "+apelido+" cadastrado com sucesso!");
        
        response.sendRedirect("LocalServletNovo?msg=Local%20"+apelido+"%20cadastrado%20com%20sucesso!");
        
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
