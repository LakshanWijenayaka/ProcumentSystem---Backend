package com.csse.procurementws.repository;

import com.csse.procurementws.model.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

    @Query("SELECT s FROM OrderItem s WHERE s.orderId = :orderId")
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    
}
