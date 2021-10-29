package com.googlepay.Googlepayments.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.googlepay.Googlepayments.entity.Googlepayments;
import com.googlepay.Googlepayments.entity.GooglepaymentsTransfer;
@Repository
public interface GooglepaymentsRepository extends JpaRepository<Googlepayments,Long>{
	
	public Googlepayments findByPhoneEquals(String phone);
    @SuppressWarnings("unchecked")
	public Googlepayments save(Googlepayments googlepay);
	
	@Query("select c from GooglepaymentsTransfer c WHERE c.fromPhoneNumber = :fromPhoneNumber")
	  public List<GooglepaymentsTransfer> generateStatement(@Param("fromPhoneNumber") String fromPhoneNumber, Pageable paging);
	  
	  

}
