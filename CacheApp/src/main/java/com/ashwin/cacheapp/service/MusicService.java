package com.ashwin.cacheapp.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/*import javax.ejb.Stateless;*/


import com.ashwin.cacheapp.dao.MusicDao;
import com.ashwin.cacheapp.model.Album;

import org.apache.jcs.JCS;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.util.Properties;

//@Stateless
public class MusicService {

//    private CacheAccess<String, List<Album>> cache = null;

    
    private MusicDao musicDao=new MusicDao();
  private JCS cache;
    

    public List<Album> getAllMusic() {
        try
             {
             Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/log4j.properties"));
            PropertyConfigurator.configure(props); 
            
       List<Album> albumList = (List) cache.get("musicCache");
     System.out.println("Size of album is"+albumList.size());
        if(albumList!=null) {
            System.out.println("Returning data from cache");
          return albumList;
           }
     } catch(Exception e ){
                 
             try{
                 System.out.println("Putting data in cache");
                 musicDao.putIncache();
             }
             catch(Exception ef){
                 
             }
             return musicDao.getAllTopHundredMusic();
     }
            
        return null;
   
    }
    


}