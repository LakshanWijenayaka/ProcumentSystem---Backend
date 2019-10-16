/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.procurementws.serviceImpl;

import com.csse.procurementws.model.Inventory;
import com.csse.procurementws.model.Item;
import com.csse.procurementws.model.Order;
import com.csse.procurementws.model.OrderItem;
import com.csse.procurementws.model.Supplier;
import com.csse.procurementws.repository.InventoryRepository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pasan Kamburugamuwa
 */


@Service
public class InventoryServiceImpl {
    
    @Autowired
    InventoryRepository inventoryrepository;
    
    public void saveItem(Inventory inventoryitem) {
        inventoryrepository.save(inventoryitem);
    }
 
    
    public List<Map<String,Object>>report() {
    	
    	List<Map<String,Object>> result =new ArrayList<Map<String,Object>>();
    	for(Inventory inventory :inventoryrepository.findAll()) {
    			Map<String,Object> item =new HashMap<String,Object>();
    			item.put("id", inventory.getId());
    			item.put("item_name",inventory.getItem_name());
    			item.put("quanitity", inventory.getQuanitity());
    			item.put("price", inventory.getPrice());
    	}
    	return result;
    }
    


}
