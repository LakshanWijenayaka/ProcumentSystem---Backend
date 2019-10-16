package com.csse.procurementws.serviceImpl;

import com.csse.procurementws.model.Supplier;
import com.csse.procurementws.repository.SupplierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author (IT17119122 ** Liyanage I.M)
 */
@Service
public class SupplierServiceImpl {
    
    @Autowired
    SupplierRepository supplierRepository;
     
    public void saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
    }
    
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.get();
    }
    
}
