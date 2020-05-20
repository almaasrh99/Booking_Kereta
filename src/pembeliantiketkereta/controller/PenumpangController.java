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
import pembeliantiketkereta.data.Penumpang;

/**
 *
 * @author Candi-PC
 */
public class PenumpangController implements Serializable{
    private EntityManagerFactory emf=null;
    public PenumpangController(EntityManagerFactory emf){
        this.emf=emf;
    }
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    
    public void savePenumpang(Penumpang penumpang)throws Exception{
        EntityManager em=getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(penumpang);
            em.getTransaction().commit();
        }catch(Exception ex){}
    }
    
    
    }
    

