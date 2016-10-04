/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.dao.PaysDAO;
import streaming.entity.Pays;

/**
 *
 * @author admin
 */
public class PaysService {
    public void ajouterPays(Pays pays){
        new PaysDAO().ajouterPays(pays);
    }
    public void modifierPays(Pays pays){
        new PaysDAO().modifierPays(pays);
    }
    public void supprimerPays(Long id){
        new PaysDAO().supprimerPays(id);
    }
    public List<Pays> listerPays(){
        return new PaysDAO().listerPays();
    }
    public Pays FindById(Long id){
        return new PaysDAO().FindById(id);
    }    
}
