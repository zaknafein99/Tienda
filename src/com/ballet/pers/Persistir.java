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
import com.ballet.dom.Producto;
import java.util.Collection;
import java.util.Iterator;
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
    
    public void actualizarProveedor(Proveedor prov){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TiendaPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        Proveedor existingProv = em.find(Proveedor.class, prov.getId());
        existingProv.setApellido(prov.getApellido());
        existingProv.setBanco(prov.getBanco());
        existingProv.setDireccion(prov.getDireccion());
        existingProv.setNombre(prov.getNombre());
        existingProv.setNroCuenta(prov.getNroCuenta());
        existingProv.setProductos(prov.getProductos());
        existingProv.setTelefono(prov.getTelefono());
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}
    
    public void venderItem(ItemStock item){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TiendaPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        ItemStock existingItem = em.find(ItemStock.class, item.getId());
        existingItem.setFechaVenta(item.getFechaVenta());
        existingItem.setPrecioVenta(item.getPrecioVenta());
        existingItem.setVendido(true);
        
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}
    
    public void cancelarVentaItem(ItemStock item){
    EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TiendaPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    try {
        ItemStock existingItem = em.find(ItemStock.class, item.getId());
        existingItem.setFechaVenta(null);
        existingItem.setPrecioVenta(0);
        existingItem.setVendido(false);
        
        em.getTransaction().commit();
    } catch (Exception e) {
        e.printStackTrace();
        em.getTransaction().rollback();
    }finally {
   em.close();
   emf.close();
   }
}
    
    public Proveedor buscarProveedor(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TiendaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Proveedor prov = null;
        try {
            Proveedor existingProv = em.find(Proveedor.class, id);
            prov = existingProv;

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
       em.close();
       emf.close();
        }
        return prov;
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
    public Proveedor buscarProveedorPorId(int id){
      Proveedor prov = new Proveedor();
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
  try{
      prov = new Proveedor();
      prov = em.find(Proveedor.class, id);
  }
  catch (Exception e) {
      System.out.println( e.getMessage() );
      em.getTransaction().rollback();
  }finally {
      em.close();
      emf.close();
  }
  return prov;
    }
    
    public Collection<Producto> listarProductos(){
      List<Producto> list = null;
      List<Producto> list2 = null;
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();

      try {
        Query query = em.createNamedQuery("Productos.findAll");
//        Query query=em.createNativeQuery("SELECT * FROM producto");

        list =  query.getResultList();
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            list2.add((Producto)it.next());
//        }

      } catch (Exception e) {
        System.out.println( e.getMessage() );
        em.getTransaction().rollback();
      } finally {
        em.close();
        emf.close();
        return list;
      }
}
    
  public ItemStock buscarItemPorId(long id){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      ItemStock item = new ItemStock();
      item = em.find(ItemStock.class, id);
      return item;
}
    
    public Collection<ItemStock> listarStock(){
      List<ItemStock> list = null;
      List<ItemStock> list2 = null;
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();

      try {
        Query query = em.createNamedQuery("Stock.findAll");
//        Query query=em.createNativeQuery("SELECT * FROM producto");

        list =  query.getResultList();
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            list2.add((Producto)it.next());
//        }

      } catch (Exception e) {
        System.out.println( e.getMessage() );
        em.getTransaction().rollback();
      } finally {
        em.close();
        emf.close();
        return list;
      }
}
    
    public Collection<Producto> listarProductosPorProveedor(Proveedor prov){
        List list = null;
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU" );
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();

      try {
          Query query = em.createNamedQuery("Productos.findByProv");
          query.setParameter("proveedor", prov);
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
