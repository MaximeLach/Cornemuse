/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cornemuse.test;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import streaming.entity.Pays;
import streaming.service.PaysService;

/**
 *
 * @author admin
 */
public class CornemuseTest {
    
//    @Before
//    public void setUp(){
//        
//    }
//    
//    @Test(expected = Exception.class)
//    public void ajouterKO(){
//        Pays p = new Pays();
//        p.setId(3L);
//        new PaysService().ajouterPays(p);
//    }
    
    @Test
    public void rechercherOK(){
        Pays p = new PaysService().FindById(2L);
        Assert.assertEquals("France", p.getNom());
        
    }
}
