package com.csse.procurementws.controller;

import com.csse.procurementws.model.CommonResponse;
import com.csse.procurementws.model.Item;
import com.csse.procurementws.serviceImpl.ItemServiceImpl;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ItemController {
    
    @Autowired
    ItemServiceImpl itemServiceImpl;
    
    @RequestMapping(value = "/save/item", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> saveItem(@Valid @RequestBody Item item) {
        try {
            item.setCurrentStatus("AVAILABLE");
            itemServiceImpl.saveItem(item);
            return new ResponseEntity<>(new CommonResponse("SUCSESS", "Item successfully saved"), HttpStatus.OK);
        } catch (Exception ex) {
            Logger logger = LoggerFactory.getLogger(SupplierController.class);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
