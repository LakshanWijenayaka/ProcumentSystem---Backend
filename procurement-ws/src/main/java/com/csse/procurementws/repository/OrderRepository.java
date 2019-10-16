package com.csse.procurementws.repository;

import com.csse.procurementws.model.Order;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
    @Transactional
    @Modifying
    @Query("update Order ord set ord.status = :status where ord.id = :id")
    int setStatusOrder(String status, Integer id);
//    update OrderPaper pop set pop.englishStatus = :status where pop.id = :id"
}
