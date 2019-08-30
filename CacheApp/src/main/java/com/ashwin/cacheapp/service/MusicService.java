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
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.engine.control.CompositeCacheManager;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.jcs.access.CacheAccess;

//@Stateless
public class MusicService {

//    private CacheAccess<String, List<Album>> cache = null;

    
    private MusicDao musicDao=new MusicDao();



      private JCS cache;

    public List<Album> getAllMusic() {
      
               System.out.println("printing from here...........");

        
         try
             {
                 
     List<Album> albumList = (List) cache.get("musicCache");
     System.out.println("Size of album is"+albumList.size());
        if(albumList!=null) {
            System.out.println("returning from cache");
          return albumList;
           }
     } catch(Exception e ){
         List<Album> albumList=musicDao.getAllTopHundredMusic();
             System.out.println(albumList.size());
             try{
                 System.out.println("albumlist is getting putting");
             cache.put("musicCache",albumList);
             }
             catch(Exception ef){
                 
             }
//           cache.put("musicCache",albumList);
       //    musicDao.putIncache();
             
             
              return musicDao.getAllTopHundredMusic();
     }
            
        return null;
   
    }
    


}