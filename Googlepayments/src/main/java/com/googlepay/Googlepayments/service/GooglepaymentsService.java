package com.googlepay.Googlepayments.service;


import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.googlepay.Googlepayments.entity.Googlepayments;
import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;

public interface GooglepaymentsService {

	Googlepayments registerGooglepayments(Googlepayments googlepayments);

	List<GooglepaymentsTransfer> generateStatement(String phoneNumber);

	Googlepayments getGooglepaymentsById(Long id) throws AccountNotFoundException;


	


}
