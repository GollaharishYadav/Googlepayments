package com.googlepay.Googlepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
@Repository
public interface GooglepaymentsTransferRepository extends JpaRepository<GooglepaymentsTransfer,Long>{
	
	public GooglepaymentsTransfer save(GooglepaymentsTransfer googlepay);
	  
}
