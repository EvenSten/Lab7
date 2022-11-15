package ca.sait.dataaccess;

import ca.sait.models.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


public class UserDB {

    public List<User> getAll() {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User get(String email) throws Exception {
        User user;
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        
        try {
             user = em.find(User.class, email);

            return user;
        } finally {
            em.close();
        }
    }

    public void delete(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();

        } finally {
            em.close();
        }
    }
    
    public void update(User user) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(user);
            trans.commit();

        } catch (Exception ex) {
            trans.rollback();

        } finally {
            em.close();
        }
    }
    
        public void create(String email, boolean activity, String first, String last, String password, Role role) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();        
        EntityManager em = emFactory.createEntityManager();     
        
        User user = new User(email, activity, first, last, password, role);
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
            
            
        } catch (Exception ex) {
            trans.rollback();
            
           
        } finally {
            em.close();
        }

    }
}