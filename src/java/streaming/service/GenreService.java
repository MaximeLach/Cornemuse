/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDAO;
import streaming.dao.GenreDAO;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class GenreService {
    public List<Genre> listerGenres(){
        return new GenreDAO().listerGenres();
    }
    public Genre rechercheGenre(Long id){
        return new GenreDAO().rechercherGenre(id);
    }
}
