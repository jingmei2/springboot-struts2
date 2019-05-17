package com.zfsoft.zftal.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Table(name = "CITY")
public class City implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "SUBDATE")
    private Date date ;

//    public City(){}
//
//    public City(Long id, String name, String state, String country, Date date) {
//        this.id = id;
//        this.name = name;
//        this.state = state;
//        this.country = country;
//        this.date = date;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", date=" + date +
                '}';
    }
}