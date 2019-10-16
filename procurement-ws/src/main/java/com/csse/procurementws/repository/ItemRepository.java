package com.csse.procurementws.repository;

import com.csse.procurementws.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
public interface ItemRepository extends JpaRepository<Item, Integer>{
    
    @Query("SELECT s FROM Item s WHERE s.id IN :idList")
    List<Item> getItemsByIdList(List<Integer> idList);
    
}
