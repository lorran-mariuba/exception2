package model.entities;

import model.exceptions.PersonalException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		amount += balance;
	}
	
	public void withdraw(Double amount) {
		if(amount > balance && amount < withdrawLimit) {
			throw new PersonalException("Not enough balance");
		}
		if(amount > withdrawLimit) {
			throw new PersonalException("The amount exceeds withdraw limit");
		}
//		if(amount > withdrawLimit && amount > balance) {
//			throw new PersonalException("The amount exceeds withdraw limit");
//		}
		balance -= amount;
	}
}
