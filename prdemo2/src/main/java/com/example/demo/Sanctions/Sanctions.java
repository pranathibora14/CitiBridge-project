package com.example.demo.Sanctions;
import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.*;
public class Sanctions {
	Transaction Tobj;
	public Sanctions(Transaction Tobj1)
	{
		this.Tobj=(Tobj1);
	}
	
	public boolean validateSanction(Transaction Tobj1){
		boolean z=true;
		try {
			amtSanction();
		}
		catch (Exceptions e){
			System.out.println("Pass on exception to Angular: "+e);
		}
		return z;
	}
	
	public void amtSanction () throws Exceptions{
		if(Tobj.getAmount()>=1000000) {
			throw new Exceptions("Sanctions can't allow this limit");
		}
		
	}
}
