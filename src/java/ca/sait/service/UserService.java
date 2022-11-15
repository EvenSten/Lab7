package ca.sait.service;

import ca.sait.models.*;
import ca.sait.dataaccess.UserDB;
import java.util.List;


public class UserService {
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
    public void update(String email, String first, String last, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first);
        user.setLastName(last);
        user.setRole(role);
        userDB.update(user);
    }
     public void create(String email, boolean activity, String first, String last, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        userDB.create(email, activity, first, last, password, role);
      
    }
}