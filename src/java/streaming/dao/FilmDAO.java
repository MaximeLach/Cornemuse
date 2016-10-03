/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import streaming.entity.Film;
import streaming.entity.Genre;

/**
 *
 * @author admin
 */
public class FilmDAO {
    public List<Film> listerFilms(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        List<Film> films = em.createQuery("SELECT f FROM Film f ORDER BY f.id DESC").getResultList();
        return films;
    }  
 
    public void ajouterFilm(Film films){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(films);
        em.getTransaction().commit();
    }
    
    public void supprimerFilm(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Film f WHERE f.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public Film rechercherFilm(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Film.class, id);
    }
    
    public void modifierFilm(Film films){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(films);
        em.getTransaction().commit();
    }
}
