package com.csse.procurementws.controller;

import com.csse.procurementws.model.CommonResponse;
import com.csse.procurementws.model.Order;
import com.csse.procurementws.model.Supplier;
import com.csse.procurementws.serviceImpl.SupplierServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
@RestController
@CrossOrigin
public class SupplierController {
    
    @Autowired
    SupplierServiceImpl supplierServiceImpl;
    
    @RequestMapping(value = "/supplier/save", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> saveSupplier(@Valid @RequestBody Supplier supplier) {
        try {
            supplierServiceImpl.saveSupplier(supplier);
            return new ResponseEntity<>(new CommonResponse("SUCSESS", "Item successfully saved"), HttpStatus.OK);
        } catch (Exception ex) {
            Logger logger = LoggerFactory.getLogger(SupplierController.class);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
            
    @RequestMapping(value = "/getsuppliers", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> getSuppliers() {
        try {
            List<Supplier> supplierList = supplierServiceImpl.getAllSuppliers();
            return new ResponseEntity<>(supplierList, HttpStatus.OK);
        } catch (Exception ex) {
            Logger logger = LoggerFactory.getLogger(SupplierController.class);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    //get the supplier from the id pasan added
    @RequestMapping(value = "/getsupplier/{id}", method = RequestMethod.GET)
    public ResponseEntity<Supplier> supplierGetById(@PathVariable(value = "id") Integer id) {
        try {
            Supplier supplier = supplierServiceImpl.getSupplierById(id); 
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (Exception ex) {
            Logger logger = LoggerFactory.getLogger(OrderController.class);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
