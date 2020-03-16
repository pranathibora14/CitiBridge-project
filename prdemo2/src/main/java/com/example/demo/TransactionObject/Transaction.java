package com.example.demo.TransactionObject;

public class Transaction {
	private String TransRef;
	private String date;
	private String PayerName;
	private String PayerAcc;
	private String PayeeName;
	private String PayeeAcc;
	private Float amount;
	private int EC;
	public Transaction(String TransRef,String date, String PayerName, String PayerAcc, String PayeeName, String PayeeAcc,Float Amount)
	{
		this.setTransRef(TransRef);
		this.setDate(date);
		this.setPayerName(PayerName);
		this.setPayerAcc(PayerAcc);
		this.setPayeeName(PayeeName);
		this.setPayeeAcc(PayeeAcc);
		this.setAmount(Amount);
		setEC(0);
	}
	
	public String getTransRef() {
		return TransRef;
	}
	public void setTransRef(String transRef) {
		TransRef = transRef;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPayerName() {
		return PayerName;
	}
	public void setPayerName(String payerName) {
		PayerName = payerName;
	}
	public String getPayerAcc() {
		return PayerAcc;
	}
	public void setPayerAcc(String payerAcc) {
		PayerAcc = payerAcc;
	}
	public String getPayeeName() {
		return PayeeName;
	}
	public void setPayeeName(String payeeName) {
		PayeeName = payeeName;
	}
	public String getPayeeAcc() {
		return PayeeAcc;
	}
	public void setPayeeAcc(String payeeAcc) {
		PayeeAcc = payeeAcc;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public int getEC() {
		return EC;
	}

	public void setEC(int eC) {
		EC = eC;
	}
}