package com.googlepay.Googlepayments.Dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FundTransfer implements Serializable {

	private Long fromAccountID;

	private Long toAccountID;

	private int amountToTransfer;
	
	private LocalDate transactionDate  = LocalDate.now();
	
	
	public Long getFromAccountID() {
		return fromAccountID;
	}

	public void setFromAccountID(Long fromAccountID) {
		this.fromAccountID = fromAccountID;
	}

	public Long getToAccountID() {
		return toAccountID;
	}

	public void setToAccountID(Long toAccountID) {
		this.toAccountID = toAccountID;
	}

	public int getAmountToTransfer() {
		return amountToTransfer;
	}

	public void setAmountToTransfer(int amountToTransfer) {
		this.amountToTransfer = amountToTransfer;
	}


	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}



}
