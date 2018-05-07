package com.fanr.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer Id;

    @Column(nullable = false , length = 50)
    private String Name;

    @Column(nullable = false)
    private String Contents;

    @Column(nullable = false)
    private String Cooking;

    @Column(nullable = false)
    private Integer Version;

    @Column(nullable = false)
    private Date Date;


    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "IdUser", referencedColumnName = "id")
    private User user;


    public User getUser() {
        return user;
    }

    public Recipe() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public String getCooking() {
        return Cooking;
    }

    public void setCooking(String cooking) {
        Cooking = cooking;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Integer getVersion() {
        return Version;
    }

    public void setVersion(Integer version) {
        Version = version;
    }


}

