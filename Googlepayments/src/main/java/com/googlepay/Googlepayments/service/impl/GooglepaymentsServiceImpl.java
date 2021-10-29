package com.googlepay.Googlepayments.service.impl;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.googlepay.Googlepayments.entity.Googlepayments;
import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
import com.googlepay.Googlepayments.repository.GooglepaymentsRepository;
import com.googlepay.Googlepayments.service.GooglepaymentsService;
@Service
public class GooglepaymentsServiceImpl implements GooglepaymentsService{
	@Autowired
	GooglepaymentsRepository googlepaymentsRepository;

	public Googlepayments registerGooglepayments(@RequestBody Googlepayments googlepayments) {
		return googlepaymentsRepository.save(googlepayments);
	}

	@Override
	public List<GooglepaymentsTransfer> generateStatement(String phoneNumber) {
		Pageable paging = PageRequest.of(0, 5);
		return googlepaymentsRepository.generateStatement(phoneNumber,paging);
	}

	@Override
	public Googlepayments getGooglepaymentsById(Long Id) throws AccountNotFoundException {
		Optional<Googlepayments> googlepayments = googlepaymentsRepository.findById(Id);
		if(googlepayments.isPresent()) {
			return googlepayments.get();
		}else {
			throw new AccountNotFoundException("Account Not found");
		}
		//return null;
	}

}
