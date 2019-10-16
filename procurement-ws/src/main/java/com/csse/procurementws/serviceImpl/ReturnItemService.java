package com.csse.procurementws.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csse.procurementws.model.Item;
import com.csse.procurementws.model.ReturnItem;

@Service
public interface ReturnItemService {

//	List<Item> getAllItems(int returnId);
//	
    ReturnItem UpdateReturnItem(ReturnItem returnItem);
    
    ReturnItem addItem(ReturnItem returnItem);
//
    List<ReturnItem> getAllReturnItem();
    
    void deleteReturnEntry(String retItemId);
//
//    List<ReturnItem> getAllReturnItems();
	
}
