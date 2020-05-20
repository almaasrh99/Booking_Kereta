/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembeliantiketkereta.controller;
import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import pembeliantiketkereta.data.User;

/**
 *
 * @author Candi-PC
 */
public class UserController implements Serializable{
    private EntityManagerFactory emf=null;
    
    public UserController(EntityManagerFactory emf){
        this.emf=emf;
    }
    
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public void save(User user) throws Exception {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch(Exception ex){}
    }
    
    public void update(User user) throws Exception{
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }catch(Exception ex){}
    }
    
    public void delete(String kode) throws Exception{
        EntityManager em = getEntityManager();
        User us;
        try{
            us=em.getReference(User.class, kode);
            us.getKodeUser();
            em.getTransaction().begin();
            em.remove(us);
            em.getTransaction().commit();
        }catch(Exception ex){}
    }
    
    public User findUser(String kode){
        EntityManager em=getEntityManager();
        try{
            return em.find(User.class, kode);
        }finally{}
    }
    
    
    } 

