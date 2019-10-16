package com.csse.procurementws.serviceImpl;

import com.csse.procurementws.model.Item;
import com.csse.procurementws.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
@Service
public class ItemServiceImpl {
    
    @Autowired
    ItemRepository itemRepository;
    
    public void saveItem(Item item) {
        itemRepository.save(item);
    }
    
    public List<Item> getItemsByIdList(List<Integer> idList) {
        return itemRepository.getItemsByIdList(idList);
    }
}
