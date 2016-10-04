/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;


import java.util.List;
import streaming.entity.Pays;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class PaysDAO {
    public void ajouterPays(Pays pays){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(pays);
        em.getTransaction().commit();
    }
    public void modifierPays(Pays pays){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(pays);
        em.getTransaction().commit();
    }
    public void supprimerPays(Long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Pays p WHERE p.id=" + id).executeUpdate();
        em.getTransaction().commit();
    }
    public List<Pays> listerPays(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        List<Pays> pays = em.createQuery("Select p FROM Pays p").getResultList();
        return pays;
    }
    public Pays FindById(Long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Pays.class, id);
    }
}
