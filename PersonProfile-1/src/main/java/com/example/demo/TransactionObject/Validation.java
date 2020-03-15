package com.example.demo.TransactionObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.ExceptionHandling.Exceptions;

public class Validation {
	Transaction Tobj;
	public Validation(Transaction Tobj1)
	{
		this.Tobj=(Tobj1);
	}
	public void validateTransaction(){
		try {
			checkrefDigits();
			checkDateFormat();
			checkPayerAccNo();
			checkPayeeAccNo();
		}
		catch (Exception e){
			System.out.println("Pass on exception to Angular");
		}
	}
	void checkrefDigits() throws Exceptions{
		if(Tobj.getTransRef().length()!=12)
		{
			Tobj.EC=1;
			throw new Exceptions("Invalid Transaction Reference");
		}
	}
	void checkDateFormat() throws Exception{
		if(Tobj.getDate().length()==8)
		{
			
			String pattern="ddMMyyyy";
			SimpleDateFormat sdf=new SimpleDateFormat(pattern);
			sdf.setLenient(false);
			try {
				Date date=sdf.parse(Tobj.getDate());
				SimpleDateFormat Format=new SimpleDateFormat("yyyy-MM-dd");
				String finalDate=Format.format(date);
				Tobj.setDate(finalDate);
				//System.out.println(finalDate);
			}
			catch(ParseException e)
			{
				throw new Exceptions("Invalid DateFormat");
			}
			
			
		}
	}
	void checkPayerAccNo() throws Exceptions{
		if(Tobj.getPayerAcc().length()<12)
		{
			Tobj.EC=3;
			throw new Exceptions("Invalid Payer Account Number");
		}
	}
	void checkPayeeAccNo() throws Exceptions{
		if(Tobj.getPayerAcc().length()<12)
		{
			Tobj.EC=4;
			throw new Exceptions("Invalid Payee Account Number");
		}
	}
}
