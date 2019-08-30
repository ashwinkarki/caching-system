/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp;

import com.ashwin.cacheapp.model.Album;
import com.ashwin.cacheapp.response.ResponseGen;
import com.ashwin.cacheapp.service.MusicService;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author ashwin.karki
 */
@Path("hello")
@RequestScoped
public class ApiResource {

   
 
    MusicService musicService=new MusicService();


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

   
}
