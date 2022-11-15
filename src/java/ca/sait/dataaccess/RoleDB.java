package ca.sait.dataaccess;

import java.util.List;
import ca.sait.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class RoleDB {
    public List<Role> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        EntityManager em = emFactory.createEntityManager();
        return em.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
}