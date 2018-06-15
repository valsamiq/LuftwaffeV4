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

/**
 *
 * @author DAM
 */
public class RegisterMision extends HttpServlet {

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
            throws ServletException, IOException {
    LutwaffeDAO dao = new LutwaffeDAO();
    
    try{
        String nombre = request.getParameter("nombre");
        int clasificacion =Integer.parseInt(request.getParameter("clasificacion")) ;
        String tipo = request.getParameter("tipo");
        String zona = request.getParameter("zona");
        Nave n = dao.getNaveFromId(Integer.parseInt(request.getParameter("nave")));
        //int naveId = Integer.parseInt(request.getParameter("nave"));
        
        Mision misionAux = new Mision(nombre, clasificacion, tipo, zona, n);
        dao.insertMision(misionAux);
        request.setAttribute("status", "La mision se ha insertado correctamente");
    } catch (SQLException ex) {
            request.setAttribute("status", ex.getMessage());
            request.getRequestDispatcher("/final.jsp").forward(request, response);
    }
    request.getRequestDispatcher("/final.jsp").forward(request, response);
        
        
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
