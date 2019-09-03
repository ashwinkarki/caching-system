package com.ashwin.secondapp;

import com.ashwin.secondapp.dao.TicketDAO;
import com.ashwin.secondapp.helper.CacheHelper;
import com.ashwin.secondapp.helper.SquaredCalculator;
import com.ashwin.secondapp.model.Ticket;
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("myresource")
public class MyResource {

    private CacheHelper cacheHelper=new CacheHelper();

    private SquaredCalculator squaredCalculator=new SquaredCalculator();

    @Inject
    private TicketDAO ticketDAO;

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("me")
    @Produces(MediaType.TEXT_PLAIN)
    public String getData() {

//        for (int i = 10; i < 15; i++) {
//            cacheHelper.getSquareNumberCache().containsKey(i);
//            System.out.println("Square value of " + i + " is: "
//                    + squaredCalculator.getSquareValueOfNumber(i) + "\n");
//        }
//
//        for (int i = 10; i < 15; i++) {
//          //  cacheHelper.getSquareNumberCache().containsKey(i);
//            System.out.println("Square value of " + i + " is: "
//                    + squaredCalculator.getSquareValueOfNumber(i) + "\n");
//        }

      //  List<Ticket> ticketList=ticketDAO.getAllTicket();
        //1. Create a cache manager
//        CacheManager cm = CacheManager.getInstance();
//
//        //2. Create a cache called "cache1"
//        cm.addCache("cache1");
//
//        //3. Get a cache called "cache1"
//        Cache cache = cm.getCache("cache1");
//
//        //4. Put few elements in cache
//        cache.put(new Element("1","Jan"));
//        cache.put(new Element("2","Feb"));
//        cache.put(new Element("3","Mar"));
//
//        //5. Get element from cache
//        Element ele = cache.get("1");
//
//        //6. Print out the element
//        String output = (ele == null ? null : ele.getObjectValue().toString());
//        System.out.println(output);
//
//        //7. Is key in cache?
//        System.out.println(cache.isKeyInCache("1"));
//        System.out.println(cache.isKeyInCache("5"));
//
//        //8. shut down the cache manager
//        cm.shutdown();
        return "Got it!";
    }


}
