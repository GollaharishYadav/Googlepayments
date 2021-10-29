package com.googlepay.GooglepaymentsController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.googlepay.Googlepayments.controller.GooglepaymentsController;
import com.googlepay.Googlepayments.entity.Googlepayments;
import com.googlepay.Googlepayments.service.GooglepaymentsService;

@ExtendWith(MockitoExtension.class)
public class GooglepaymentsControllerTest {
	@InjectMocks
	
	 GooglepaymentsController googlepaymentsController;
	
	@Mock
	GooglepaymentsService googlepaymentsService;
	
	 static Googlepayments googlepayments = new Googlepayments();
	 static Googlepayments request = new Googlepayments();
	 static String string = new String();
	

	
	
	@BeforeAll
	public static void SetUp(){
		
		
		googlepayments.setId(null);
		googlepayments.setFirstName("Harish");
		googlepayments.setLastName("Hari");
		googlepayments.setPhone(null);
	
		
		request.setFirstName("Harish");
		request.setLastName("Hari");
		request.setPhone(null);
		request.setPhone(null);
		
	
	}
	
	@Test
	public void  registerGooglepaymentsTest() {
		Mockito.when(googlepaymentsService.registerGooglepayments(request)).thenReturn(googlepayments);
		
		Googlepayments result = googlepaymentsController.addGooglepayments(request);
		assertEquals("Harish", result.getFirstName());
	}
	
}



