/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Serie;
import streaming.service.SerieService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ModifierSerieServlet", urlPatterns = {"/modifier_serie"})
public class ModifierSerieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Serie s = new Serie();
        s.setId(Long.valueOf(req.getParameter("id")));
        s.setTitre(req.getParameter("titre"));
        s.setSynopsis(req.getParameter("synopsis"));
        new SerieService().modifier(s);
        resp.sendRedirect("liste_series");   
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Serie maSerie = new SerieService().rechercher(Long.valueOf(req.getParameter("monid")));
        req.setAttribute("maSerie", maSerie);
        req.getRequestDispatcher("modifier_serie.jsp").forward(req, resp);
    }

    

}
