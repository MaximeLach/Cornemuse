/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.entity.Genre;
import streaming.service.FilmService;
import streaming.service.GenreService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterFilm", urlPatterns = {"/ajouter_film"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Genre> listeGenres = new GenreService().listerGenres();
        req.setAttribute("listeGenres", listeGenres);
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film f = new Film();
        f.setGenre(new GenreService().rechercheGenre(Long.valueOf(req.getParameter("genreId"))));
        f.setTitre(req.getParameter("titre"));
        f.setSynopsis(req.getParameter("synopsis"));
        f.setAnnee(Integer.valueOf(req.getParameter("annee")));
        f.setDuree(Integer.valueOf(req.getParameter("duree")));
        new FilmService().ajouter(f);
        resp.sendRedirect("liste_films");
    }
}