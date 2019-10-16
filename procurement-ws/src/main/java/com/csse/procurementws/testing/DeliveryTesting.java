package com.csse.procurementws.testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.csse.procurementws.controller.DeliveryDetailsController;
import com.csse.procurementws.model.ReturnedGoods;
import com.csse.procurementws.repository.ReturnedGoodsRepository;
import com.csse.procurementws.serviceImpl.ReturnedGoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryTesting {
	
	private MockMvc mockmvc;
	
	@InjectMocks
	private DeliveryDetailsController testDeliveryController;
	
	
	
	@Before
	public void setUp() throws Exception{
		
		mockmvc = MockMvcBuilders.standaloneSetup(testDeliveryController)
				.build();
	}
	
	@Test
	public void testGetMethod() throws Exception{
		
		mockmvc.perform(
				MockMvcRequestBuilders.get("/test")
		)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Testing"));
		
		
	}
	
	

}
