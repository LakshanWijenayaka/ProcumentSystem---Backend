/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.procurementws.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Pasan Kamburugamuwa
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "ITEM_NAME")
    private String item_name;
   
    @Column(name = "QTY")
    private int quanitity;
    
    @Column(name = "PRICE")
    private double price;
    
    public Integer getId() {
        return id;
    }
    
    public String getItem_name() {
        return item_name;
    }

    public int getQuanitity() {
        return quanitity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name; 
    }
    public void setQuanitity(int quanitity) {
        this.quanitity = quanitity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
    
}
