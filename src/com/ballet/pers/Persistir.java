/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ballet.pers;

/**
 *
 * @author Isma
 */
import com.ballet.dom.*;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

public class Persistir {
    
    static private Persistir pers = new Persistir();
    private Persistir(){}
    
    static public Persistir getInstancia(){
        return pers;
    }
    
    public void guardar(Object object) {
       EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TiendaPU");
       EntityManager em = emf.createEntityManager();
       EntityTransaction  tx = em.getTransaction();
       tx.begin();
       try {
           em.persist(object);
           tx.commit();
       } catch (Exception e) {
           tx.rollback();
       } finally {
           em.close();
           emf.close();

       }
   }
    
    public Collection<Proveedor> listarProveedores(){
      List list = null;
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();

      try {
        Query query = em.createNamedQuery("Proveedores.findAll");

        list =  query.getResultList();


      } catch (Exception e) {
        System.out.println( e.getMessage() );
        em.getTransaction().rollback();
      } finally {
        em.close();
        emf.close();
        return list;
      }
}
    
}
