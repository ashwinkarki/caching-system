/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp;

import com.ashwin.cacheapp.dao.UserDAO;
import com.ashwin.cacheapp.dao.impl.UserDAOImpl;
import com.ashwin.cacheapp.model.Album;
import com.ashwin.cacheapp.model.User;
import com.ashwin.cacheapp.service.MusicService;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;


/**
 * REST Web Service
 *
 * @author ashwin.karki
 */
@Path("hello")
@RequestScoped
public class ApiResource {

   
 
    MusicService musicService=new MusicService();
    
    @Inject
    private UserDAO userDAO;

    @GET
    @Produces("text/plain")
    public String getText() {
       return "hello";
    }
    
    @GET
    @Path("getAllMusic")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Album> getAllMusic() {
        List<Album> albumList=musicService.getAllMusic();
       
        return musicService.getAllMusic();
//        return ResponseGen.success(musicService.getAllMusic());
    }
    
    @GET
@Path("/addusers")
@Produces("text/plain")
public String insertUser() {
        User user1 = new User(3L,"vvv", "KTM");
User user2 = new User(1L,"ccc", "BKT");
User user3 = new User(2L,"xxx", "PTN");
System.out.println("userdao:::::::" + userDAO);
userDAO.insertUser(user1);
userDAO.insertUser(user2);
userDAO.insertUser(user3);
return "success";
}
 
@GET
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public List<User> getAllUsers(){
 List<User> userList=new ArrayList<>();
int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
.getCache("User").getSize();
System.out.println("cahce size  all users :::::::::" + size);
 
Cache cache = CacheManager.getInstance().getCache("User");

userList = userDAO.getAllUser();
return userList;
}

   
}
