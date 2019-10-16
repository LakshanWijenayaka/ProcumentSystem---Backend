package com.csse.procurementws.repository;

import com.csse.procurementws.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	

}
