package com.googlepay.Googlepayments.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.googlepay.Googlepayments.entity.Googlepayments;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.googlepay.Googlepayments.repository.GooglepaymentsRepository;
import com.googlepay.Googlepayments.service.impl.GooglepaymentsServiceImpl;

@ExtendWith(SpringExtension.class)
public class GooglepaymentsServiceImplTest {
	@InjectMocks
	GooglepaymentsServiceImpl googlepaymentsServiceImpl;

	@Mock
	
	GooglepaymentsRepository googlepaymentsRepository;

	@Test
	public void testGetGoogleByIdForPositive() throws AccountNotFoundException {

		Googlepayments googlepayments = new Googlepayments();
		
		googlepayments.setId(1L);
		
		googlepayments.setFirstName("Ram");
				

		Mockito.when(googlepaymentsRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(googlepayments));

		Googlepayments dbGooglepayments =	googlepaymentsServiceImpl.getGooglepaymentsById(2L);

		assertNotNull(dbGooglepayments);
		assertEquals("Ram", dbGooglepayments.getFirstName());


	}
	@Test
	public void testGetGooglepaymentsByIdForException(){

		Googlepayments googlepayments = new Googlepayments();
		googlepayments.setId(1L);
		googlepayments.setFirstName("Ram");

		Mockito.when(googlepaymentsRepository.findById(1L)).thenReturn(Optional.of(googlepayments));

		try {
			Googlepayments dbGoogle = googlepaymentsServiceImpl.getGooglepaymentsById(2L);
			assertTrue(false);
		} catch (AccountNotFoundException e) {
			System.out.println("exception==========>");
			assertTrue(true);
		}
	}


}
