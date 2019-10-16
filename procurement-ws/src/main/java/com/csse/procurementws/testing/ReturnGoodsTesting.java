package com.csse.procurementws.testing;

import static org.junit.Assert.assertEquals;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.csse.procurementws.controller.DeliveryDetailsController;
import com.csse.procurementws.repository.ReturnedGoodsRepository;
import com.csse.procurementws.serviceImpl.ReturnedGoodsService;
import com.csse.procurementws.model.ReturnedGoods;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReturnGoodsTesting {
	
	private MockMvc mockmvc;
	
	@Autowired
	private ReturnedGoodsService service;
	
	@MockBean
	private ReturnedGoodsRepository repository;
	
	
	@Test
	public void getReturnedGoodsTest() {
		
		when(repository.findAll()).thenReturn(Stream.of(new ReturnedGoods(1,"2003","testItem1","1200.00"),new ReturnedGoods(2,"2002","testItem2","2200.00")).collect(Collectors.toList()));
		
		assertEquals(2, service.getAllReturnItem().size());
		
	}
	
	@Test
	public void saveReturnedGoods() {
		
		ReturnedGoods returngoods = new ReturnedGoods(1,"2003","testItem1","1200.00");
		when(repository.save(returngoods)).thenReturn(returngoods);
		
		assertEquals(returngoods, service.addItem(returngoods));
	}
}
