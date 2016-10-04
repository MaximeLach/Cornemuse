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
public class GenreDAO {
    public List<Genre> listerGenres(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        List<Genre> listegenres = em.createQuery("SELECT g FROM Genre g").getResultList();
        return listegenres;
    }
    public Genre rechercherGenre(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Genre.class, id);
    }
    public void ajouterGenre(Genre genre){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }
    public void modifierGenre(Genre genre){
        EntityManager em= Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(genre);
        em.getTransaction().commit();
    }
    public void supprimerGenre(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Genre g WHERE g.id =" + id).executeUpdate();
        em.getTransaction().commit();
    }
    
}
