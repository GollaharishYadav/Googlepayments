package com.googlepay.Googlepayments.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlepay.Googlepayments.entity.Googlepayments;
import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
import com.googlepay.Googlepayments.service.GooglepaymentsService;

@RestController
@RequestMapping("/Customers")
public class GooglepaymentsController {
	
	@Autowired
	GooglepaymentsService googlepaymentsService;
	
	
   @PostMapping("/registerGooglepayments")
   public  Googlepayments addGooglepayments(@RequestBody Googlepayments googlepayments) {
		
		return googlepaymentsService.registerGooglepayments(googlepayments);
}
   @GetMapping("/{googlepayId}")
	public Googlepayments getGooglepaymentsById(@PathVariable Long Id) throws AccountNotFoundException {
		return  googlepaymentsService.getGooglepaymentsById(Id);
  }
   @GetMapping("/generateStatement/{phoneNumber}")
   public List<GooglepaymentsTransfer> generateStatement(@PathVariable String phoneNumber) {
	   
	   return googlepaymentsService.generateStatement(phoneNumber);
   }

}
