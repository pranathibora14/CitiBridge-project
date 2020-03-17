package com.example.demo.TransactionObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.Transaction;

public class Validation {
	Transaction Tobj;
	public Validation(Transaction Tobj1)
	{
		this.Tobj=(Tobj1);
	}
	public boolean validateTransaction(){
		boolean z=true;
		try {
			checkrefDigits();
			checkDateFormat();
			checkCurrentDate();
			checkPayerAccNo();
			checkPayeeAccNo();
			Tobj.setEC(1);
		}
		catch (Exceptions e){
			System.out.println("Pass on exception to Angular: "+e);
			String res=e.toString();
			System.out.println(res+"passing it onnn");
			Tobj.setReason(res);
			z=false;
			Tobj.setEC(2);
		}
		return z;
	}
	void checkrefDigits() throws Exceptions{
		if(Tobj.getTransRef().length()!=12)
		{
			Tobj.setEC(1);
			throw new Exceptions("Invalid Transaction Reference");
		}
	}
	void checkDateFormat() throws Exceptions{
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
				throw new Exceptions("Invalid Date Format");
			}
			
			
		}
	}
	void checkCurrentDate() throws Exceptions
	{
		  try{
			    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(Tobj.getDate());; 
			    Date currDate=new Date();
			    System.out.println(currDate);
			    if(date1.getDate()!=(currDate.getDate()) || date1.getMonth()!=(currDate.getMonth()) || date1.getYear()!=(currDate.getYear()))
			    {
			        throw new Exceptions("Not Current Date");
			        
			    }
				}
				catch(ParseException e)
				{
					throw new Exceptions("Invalid Date Format");
				}
	}
	void checkPayerAccNo() throws Exceptions{
		if(Tobj.getPayerAcc().length()<12)
		{
			Tobj.setEC(3);
			throw new Exceptions("Invalid Payer Account Number");
		}
	}
	void checkPayeeAccNo() throws Exceptions{
		if(Tobj.getPayerAcc().length()<12)
		{
			Tobj.setEC(4);
			throw new Exceptions("Invalid Payee Account Number");
		}
	}
}
