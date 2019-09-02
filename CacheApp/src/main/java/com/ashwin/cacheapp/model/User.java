/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashwin.cacheapp.model;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 *
 * @author ashwin.karki
 */
@Data
@Cacheable(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "User")
@Entity
@Table(name = "USERINFO")
@NamedQueries({
@NamedQuery(name = "User.findAll", query = "select u from User u ", hints = {
@QueryHint(name = "org.hibernate.cacheable", value = "true")}),
@NamedQuery(name = "User.findById", query = "select u from User u where u.id = :id")
})
@XmlRootElement(name = "user")
public class User implements Serializable {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
private Long id;
@Column(name = "USER_NAME")
private String userName;
@Column(name = "USER_ADDRESS")
private String userAddress;
 
public User() {
}
 
public User(Long id) {
this.id = id;
}
 
public User(String userName, String userAddress) {
this.userName = userName;
this.userAddress = userAddress;
}

    public User(Long id, String userName, String userAddress) {
        this.id = id;
        this.userName = userName;
        this.userAddress = userAddress;
    }



 }