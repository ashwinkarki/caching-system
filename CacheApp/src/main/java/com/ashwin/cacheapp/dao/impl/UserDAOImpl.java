/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp.dao.impl;
import com.ashwin.cacheapp.dao.UserDAO;
import com.ashwin.cacheapp.model.User;
import com.ashwin.cacheapp.util.HibernateConnector;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
@Stateless
public class UserDAOImpl implements UserDAO {
 
@PersistenceContext(unitName = "UserPA")
private  EntityManager em;
 
 
@Override
public User findById(long id) {
return (User) em.createNamedQuery("User.findById")
.setParameter("id", id)
.getSingleResult();
}
 
@Override
public void insertUser(User user) {
 
  System.out.println("em:::::" + em);
  em.persist(user);
//     Session session = null;
//        Transaction transaction = null;
//        try {
//            session = HibernateConnector.getInstance().getSession();
//            System.out.println("session : "+session);
//            transaction = session.beginTransaction();
//            session.save(user);
//            transaction.commit();
//           // return student;
//        } catch (Exception e) {
//            e.printStackTrace();
//           // return null;
//        }
}
 
@Override
public boolean updateUser(long id, User data) {
User user =  findById(id);
user.setUserName(data.getUserName());
user.setUserAddress(data.getUserAddress());
em.merge(user);
return true;
}

    @Override
    public List<User> getAllUser() {
      return em.createNamedQuery("User.findAll")
.getResultList();
    }
}