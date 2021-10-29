package com.googlepay.Googlepayments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
import com.googlepay.Googlepayments.service.GooglepaymentsTransferService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
@RequestMapping("/fundTransfer")
public class GooglepaymentsTransferController {
	
	@Autowired
	GooglepaymentsTransferService googlepaymentsTransferService;	
	
	@PostMapping
	@HystrixCommand(fallbackMethod="transferFundFallBackMethod")
	public GooglepaymentsTransfer transferFund(@RequestBody  GooglepaymentsTransfer  googlepaymentsTransfer) {
		return googlepaymentsTransferService.transferFund( googlepaymentsTransfer);
		
	}
	
	public GooglepaymentsTransfer transferFundFallBackMethod(@RequestBody  GooglepaymentsTransfer  googlepaymentsTransfer) {
		
		googlepaymentsTransfer.setComments("Does Not Exit");
		googlepaymentsTransfer.setTransferAmount(0);
		return googlepaymentsTransfer;
		
	}
}
