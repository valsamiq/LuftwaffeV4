/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LutwaffeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.Mision;
import obj.Nave;
import obj.Tripulacion;

/**
 *
 * @author daw2
 */
public class CheckExit extends HttpServlet {
LutwaffeDAO dao = new LutwaffeDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
        int idDelete = Integer.parseInt(request.getParameter("id"));
        int exit = dao.getRand();
        Tripulacion t = dao.getTripulacionById(idDelete);
        if(exit>5){
            //Exito Mision, no hace nada
            request.setAttribute("status", "La mision ha procedido con exito!");
            dao.deleteTripulacion(t);
        }else{
            //Cagada, borra cosikas
            dao.deleteTripulacion(t);
            dao.deletePersonal(dao.getPersonalFromId(t.getId()));
            Mision n = dao.getMisionById(t.getIdMision().getId());
            dao.deleteMision(dao.getMisionById(t.getIdMision().getId()));
            //No consio hacer el último!!!!!!
            //dao.deleteNave(dao.getNaveFromId(dao.getMisionById(n.getIdNave().getId())));
        }
    }catch (SQLException ex) {
            request.setAttribute("status", ex.getMessage());
            request.getRequestDispatcher("/final.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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