package com.googlepay.Googlepayments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlepay.Googlepayments.Dto.FundTransfer;
import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
import com.googlepay.Googlepayments.feignclient.BankAccountClient;
import com.googlepay.Googlepayments.repository.GooglepaymentsTransferRepository;
import com.googlepay.Googlepayments.service.GooglepaymentsTransferService;
@Service
public class GooglepaymentsTransferServiceImpl implements GooglepaymentsTransferService {
	
	@Autowired
	GooglepaymentsTransferRepository googlepaymentsTransferRepository;
	
	@Autowired
	BankAccountClient bankAccountClient;

	
	public GooglepaymentsTransfer transferFund(GooglepaymentsTransfer googlepaymentsTransfer) {
        FundTransfer fundTransfer = new FundTransfer();
		
		Long fromAccountID = bankAccountClient.getAccountIdFromPhoneNumber(googlepaymentsTransfer.getFromPhoneNumber());
		System.out.println("fromAccountID - "+fromAccountID);
		Long toAccountID = bankAccountClient.getAccountIdFromPhoneNumber(googlepaymentsTransfer.getToPhoneNumber());
		System.out.println("toAccountID - " + toAccountID);
		fundTransfer.setAmountToTransfer(googlepaymentsTransfer.getTransferAmount());
		fundTransfer.setFromAccountID(fromAccountID);
		fundTransfer.setToAccountID(toAccountID);
		
		
		bankAccountClient.transferFund(fundTransfer);
		
		System.out.println("toAccountID after fund transfer - " + toAccountID);
		return googlepaymentsTransferRepository.save(googlepaymentsTransfer);
	}

}
