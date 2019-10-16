package com.csse.procurementws.controller;
import com.csse.procurementws.repository.*;
import com.csse.procurementws.serviceImpl.ReturnItemReport;
import com.csse.procurementws.serviceImpl.ReturnItemService;
import com.csse.procurementws.model.ReturnItem;
import com.csse.procurementws.model.Supplier;
import com.csse.procurementws.controller.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/ReturnItemController")
public class ReturnItemsController {

    @Autowired
    private ReturnItemService returnItemService;

    @PostMapping(value = "/addReturnedItem")
    public ReturnItem addItem(@RequestBody ReturnItem returnItem){
        return  returnItemService.addItem(returnItem);
    }

   
    @GetMapping(value = "/getAllReturnItem")
    public List<ReturnItem> getAllReturnItems(){
    	
        return  returnItemService.getAllReturnItem();

    }
    @PostMapping(value = "/updateReturnItem")
    public ReturnItem UpdateReturnItem(@RequestBody ReturnItem returnItem){
        return returnItemService.UpdateReturnItem(returnItem);
    }

    @DeleteMapping("/deleteReturnEntry/{retItemId}")
    void deleteEmployee(@PathVariable String retItemId) {
        returnItemService.deleteReturnEntry(retItemId);
    }

    
    //////////////////////////////////////REPORTS////////////////

    
    @RequestMapping(value = "/printFullReport", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnItem>> printReport() {
        try {
            List<ReturnItem> returnList = returnItemService.getAllReturnItem();
            ArrayList<ReturnItem> printAllReport = new ArrayList<>(returnList);
            ReturnItemReport l1 = new ReturnItemReport();
            l1.generateLowStockLevelPdf(printAllReport);
            
            return new ResponseEntity<>(returnList, HttpStatus.OK);
            
        } catch (Exception ex) {
            Logger logger = LoggerFactory.getLogger(SupplierController.class);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}