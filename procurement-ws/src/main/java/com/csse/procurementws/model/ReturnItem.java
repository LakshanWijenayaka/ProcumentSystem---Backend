package com.csse.procurementws.model;


import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "returnitems")
public class ReturnItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RETURNITEMID")
    private int retItemId;
    
    @Column(name = "RETDATE")
    private String retDate;
    
    @Column(name = "RETITEMNAME")
    private String retItemName;
    
    @Column(name = "PRICE")
    private String price;
   
	public int getRetItemId() {
		return retItemId;
	}
	
	public void setRetItemId(int retItemId) {
		this.retItemId = retItemId;
	}
	
	public String getRetDate() {
		return retDate;
	}
	
	public void setRetDate(String retDate) {
		this.retDate = retDate;
	}
	
	public String getRetItemName() {
		return retItemName;
	}
	
	public void setRetItemName(String retItemName) {
		this.retItemName = retItemName;
	}
	
	public String getSupplier() {
		return price;
	}
	
	public void setSupplier(String supplier) {
		this.price = supplier;
	}

    
    
}