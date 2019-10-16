package com.csse.procurementws.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csse.procurementws.model.Item;
import com.csse.procurementws.model.ReturnItem;
import com.csse.procurementws.repository.ReturnItemRepository;

@Service
public class ReturnItemServiceImpl implements ReturnItemService {
	
	
    @Autowired
    private ReturnItemRepository returnItemRepository;

    @Override
    public ReturnItem addItem(ReturnItem returnItem) {
        return returnItemRepository.save(returnItem);

    }

    @Override
    public List<ReturnItem> getAllReturnItem() {
        System.out.println("weda");
        return returnItemRepository.findAll();
    }

    @Override
    public ReturnItem UpdateReturnItem(ReturnItem returnItem) {
        System.out.println("updateweda");
        return returnItemRepository.save(returnItem);
    }

    @Override
    public void deleteReturnEntry(String retItemId) {

        returnItemRepository.deleteById(Integer.parseInt(retItemId));
    }


}