/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import streaming.service.FilmService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListeFilmServlet", urlPatterns = {"/liste_films"})
public class ListeFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> films = new FilmService().lister();
        
        req.setAttribute("mesfilms", films);
        req.setAttribute("piedDePage","@2016 Maxime Lach");
        
        req.getRequestDispatcher("lister_films.jsp").forward(req, resp);
        
    }
    
   
}
