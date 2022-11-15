/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.dataaccess;

import ca.sait.models.User;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author evand
 */
public class UserDB {
    public List<User> getAll(){
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    public boolean create(String email, String first, String last, String password){
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        User user = new User();
        
        user.setEmail(email);
        user.setFirstName(first);
        user.setLastName(last);
        user.setPassword(password);
        
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(user);
            trans.commit();
            
            return true;
        }catch (Exception ex) {
            trans.rollback();
            return false;
        }finally {
            em.close();
        }
    }
    
}
