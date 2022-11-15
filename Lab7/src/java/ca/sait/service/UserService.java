/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.service;

import ca.sait.dataaccess.UserDB;
import ca.sait.models.User;
import java.util.List;

/**
 *
 * @author evand
 */
public class UserService {
    public List<User> getAll(){
        UserDB userDB =  new UserDB();
        
        List<User> users = userDB.getAll();
        
        return users;
        
    }
    
    public boolean create(String email, String first, String last, String password ){
        UserDB userDB =  new UserDB();
        
        boolean created = userDB.create(email, first, last, password);
        return created;
    }
}
