/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.procurementws.repository;

import com.csse.procurementws.model.SystemUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csse.procurementws.model.Inventory;
import com.csse.procurementws.model.Item;

/**
 *
 * @author Pasan Kamburugamuwa
 */

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	



}
