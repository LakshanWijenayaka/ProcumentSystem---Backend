package com.csse.procurementws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.csse.procurementws.model.ReturnItem;

public interface ReturnItemRepository extends JpaRepository<ReturnItem,Integer>{
	
}