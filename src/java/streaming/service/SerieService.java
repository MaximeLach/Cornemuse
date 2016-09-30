/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SerieDAO;
import streaming.entity.Serie;

/**
 *
 * @author admin
 */
public class SerieService {
    public List<Serie> lister(){
        return new SerieDAO().listerSeries();
    }
    public void ajouter(Serie series){
        new SerieDAO().ajouterSerie(series);
    }
    
    public void supprimer(long id){
        new SerieDAO().supprimerSerie(id);
    }
    
    public Serie rechercher(long id){
        return new SerieDAO().rechercherSerie(id);
    }
    
    public void modifier(Serie series){
        new SerieDAO().modifierSerie(series);
    }
}
