package com.ashwin.cacheapp.dao;


import com.ashwin.cacheapp.model.Album;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.engine.control.CompositeCacheManager;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class MusicDao {
  private List<Album> albumList=new ArrayList<Album>();
    private JCS cache;

//    static final
//    List<Album> albumList=new ArrayList<Album>() {{
//        albumList.add(new Album(1, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(2, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(3, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(4, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(5, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(6, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(7, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(8, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(9, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(10, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(11, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(12, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(13, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(14, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(15, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(16, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(17, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(18, "Toby Mac", "Diverse City"));
//        albumList.add(new Album(19, "Toby Mac", "Diverse City"));
//
//    }};






    public List<Album> getAllMusic() {
           return null;

    }

    public List<Album> getAllTopHundredMusic() {
        System.out.println("At album lsit");
   
        albumList.add(new Album(1, "Toby Mac", "Diverse City"));
        albumList.add(new Album(2, "Toby Mac", "Diverse City"));
        albumList.add(new Album(3, "Toby Mac", "Diverse City"));
        albumList.add(new Album(4, "Toby Mac", "Diverse City"));
        albumList.add(new Album(5, "Toby Mac", "Diverse City"));
        albumList.add(new Album(6, "Toby Mac", "Diverse City"));
        albumList.add(new Album(7, "Toby Mac", "Diverse City"));
        albumList.add(new Album(8, "Toby Mac", "Diverse City"));
        albumList.add(new Album(9, "Toby Mac", "Diverse City"));
        albumList.add(new Album(10, "Toby Mac", "Diverse City"));
        albumList.add(new Album(11, "Toby Mac", "Diverse City"));
        albumList.add(new Album(12, "Toby Mac", "Diverse City"));
        albumList.add(new Album(13, "Toby Mac", "Diverse City"));
        albumList.add(new Album(14, "Toby Mac", "Diverse City"));
        albumList.add(new Album(15, "Toby Mac", "Diverse City"));
        albumList.add(new Album(16, "Toby Mac", "Diverse City"));
        albumList.add(new Album(17, "Toby Mac", "Diverse City"));
        albumList.add(new Album(18, "Toby Mac", "Diverse City"));
        albumList.add(new Album(19, "Toby Mac", "Diverse City"));

       return albumList;

    }

    public void putIncache() {
        try {
            
            System.out.println("Going to put in cache........................");
            
            CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();
            Properties props = new Properties();

            props.put("jcs.default","DC");
            props.put("jcs.default.cacheattributes",
                    "org.apache.jcs.engine.CompositeCacheAttributes");
// lots more props.put - this is basically the contents of cache.ccf
            Logger log
                    = Logger.getLogger(MusicDao.class);

            ccm.configure(props);

            // Load the cache
            cache = JCS.getInstance("musicCache");

            // Initialize the cache
           /* allAlbumList.forEach(s-> {
                  cache.put(new Integer(1),
                          s)
            });*/
            
            cache.put(1,albumList.get(0));
//            int i=0;
//            for(Album a:albumList){
//                cache.put(new Integer(i+1), a);
//              
//            }


        } catch (CacheException e) {
            System.out.println("here");
            e.printStackTrace();
        }
    }
}
