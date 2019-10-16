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
import com.csse.procurementws.repository.CreditNoteRepository;
import com.csse.procurementws.repository.ReturnedGoodsRepository;
import com.csse.procurementws.serviceImpl.CreditNoteServiceImpl;
import com.csse.procurementws.serviceImpl.ReturnedGoodsService;
import com.csse.procurementws.model.CreditNote;
import com.csse.procurementws.model.ReturnedGoods;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreditNoteTesting {
	
	private MockMvc mockmvc;
	
	@Autowired
	private CreditNoteServiceImpl service;
	
	@MockBean
	private CreditNoteRepository repository;
	
	
	@Test
	public void getCreditNoteTest() {
		
		when(repository.findAll()).thenReturn(Stream.of(new CreditNote(1,"E001","Expired"),new CreditNote(2,"E002","Expired")).collect(Collectors.toList()));
		assertEquals(2, service.getAllCreditItem().size());
	}
	
	@Test
	public void saveReturnedGoods() {
		
		CreditNote creditnotes = new CreditNote(1,"E001","Expired");
		when(repository.save(creditnotes)).thenReturn(creditnotes);
	
	}
	
	
}