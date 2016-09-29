/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import streaming.dao.FilmDAO;
import java.util.List;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public class FilmService {
    public List<Film> lister(){
        return new FilmDAO().listerFilms();
    }
    
    public void ajouter(Film films){
        new FilmDAO().ajouterFilm(films);
    }
    
    public void supprimer(long id){
        new FilmDAO().supprimerFilm(id);
    }
    
    public Film rechercher(long id){
        return new FilmDAO().rechercherFilm(id);
    }
    
    public void modifier(Film films){
        new FilmDAO().modifierFilm(films);
    }
}
