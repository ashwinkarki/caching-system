/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp.dao;
import com.ashwin.cacheapp.model.User;
import java.util.List;
import javax.ejb.Local;
 
/**
*
* @author rashim.dhaubanjar
*/
@Local
public interface UserDAO {
    
    public List<User> getAllUser();
 
public   User findById(long id);
 
public void insertUser(User user);
 
public boolean updateUser(long id, User user);
 
}
