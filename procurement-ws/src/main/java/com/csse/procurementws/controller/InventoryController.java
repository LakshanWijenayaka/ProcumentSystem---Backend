/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.procurementws.controller;
import java.io.InputStream;

import java.io.OutputStream;

import com.csse.procurementws.model.CommonResponse;

import com.csse.procurementws.serviceImpl.InventoryServiceImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csse.procurementws.model.Inventory;
import com.csse.procurementws.repository.InventoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;


/**
 *
 * @author Pasan Kamburugamuwa
 */
@RestController
@CrossOrigin
public class InventoryController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    InventoryServiceImpl inventoryserviceImpl;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @Autowired
    ApplicationContext context;
    
    @Autowired
    private DataSource dataSource;
    
    @GetMapping("/test")
    public String testGetMethod() {
    	return "Testing";
    }
    
    @Autowired
    InventoryRepository inventoryrepository;
    
    @RequestMapping(value = "/save/inventoryitem", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> saveItem(@Valid @RequestBody Inventory inventoryitem) {
        try {    
            inventoryserviceImpl.saveItem(inventoryitem);
            return new ResponseEntity<>(new CommonResponse("SUCSESS", "Item successfully Added"), HttpStatus.OK);      
        } catch (Exception ex) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    } 
    
    @GetMapping("/inventoryItems")
    public List<Inventory> getAllNotes() {
        return inventoryrepository.findAll();
    }  

    @RequestMapping(value = "/InventoryPDF",method = RequestMethod.GET)
    public @ResponseBody void InventoryPDF(HttpServletResponse response) {
 	try {
        	InputStream jasperStream = this.getClass().getResourceAsStream("/report/SupplierInventory.jrxml");
        	
        	if(jasperStream != null) {
				JasperDesign design = JRXmlLoader.load(jasperStream);
				log.info(design.toString());
				
				JasperReport report  = JasperCompileManager.compileReport(design);
	
				Map<String,Object> parameterMap = new HashMap();
				List<Inventory> inventory = inventoryrepository.findAll();
				log.info(inventory.toString());	
				
				
				JRDataSource jRdatasource = new JRBeanCollectionDataSource(inventory);
				log.info(jRdatasource.toString());
				
				parameterMap.put("datasource",jRdatasource);
	//			JasperPrint jasperprint = JasperFillManager.fillReport(report, parameterMap,jRdatasource);
				response.setContentType("application/x-pdf");
				response.setHeader("Content-Disposition","inline:filename=Inventory.pdf");
				
				final OutputStream outputstream = response.getOutputStream();
	//			JasperExportManager.exportReportToPdfStream(jasperprint,outputstream);
        	}
        	else {
    			log.info("");
        		
        	}
			
    	} catch (JRException e) {
			// TODO Auto-generated catch block
			log.info("can't load the file");
    	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.info("Can't print the pdf");	
		}
    	
    }
    

}  
    
    
    