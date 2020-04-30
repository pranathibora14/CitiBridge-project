package com.example.demo.Sanctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.*;

public class Sanctions {
	Transaction Tobj;
	List<String> countries = new ArrayList<String>();
	public Sanctions(Transaction Tobj1)
	{
		this.Tobj=(Tobj1);
	}
	
	public boolean validateSanction(Transaction Tobj1){
		boolean z=true;
		try {
			formatNames();
			checkValidCountry();
			checkBanCountry();
			searchPayer();
			searchPayee();
			amtSanction();
			
		}
		catch(IOException e)
		{
			System.out.println("Could not read Sanctions file.");
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
	public void formatNames() 
	{
		//System.out.println("Payer Name: "+Tobj.getPayerName());
		String PayerName=Tobj.getPayerName().replaceAll("[^a-zA-Z]", "");
		Tobj.setPayerName(PayerName);
		System.out.println("PayerName edited: "+Tobj.getPayerName());
		
		//System.out.println("PayeeName: "+Tobj.getPayeeName());
		String PayeeName=Tobj.getPayeeName().replaceAll("[^a-zA-Z]", "");
		Tobj.setPayeeName(PayeeName);
		System.out.println("PayeeName edited: "+Tobj.getPayeeName());
	}
	public void searchPayer() throws IOException, Exceptions{
		File file = new File("C:\\Users\\nigudkar\\Desktop\\CitiProj\\github\\CitiBridge-project\\Sanctions_List.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader input = new BufferedReader(fileReader);
		char [] parse = {' '};
		String delims = new String(parse);
		String line = input.readLine();
		//System.out.println(line);
        String [] lineWords = line.split(delims);
        for(int i=0;i<lineWords.length;i++)
        {
           	//System.out.println(lineWords[i]);
           	if(Tobj.getPayerName().equalsIgnoreCase(lineWords[i]))
            {
            	System.out.println("Name found in Sanctions list");
            	throw new Exceptions("Payer Name in sanctions list");
            }
        }	
	}
	public void searchPayee() throws IOException,Exceptions{
		File file = new File("C:\\Users\\nigudkar\\Desktop\\CitiProj\\github\\CitiBridge-project\\Sanctions_List.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader input = new BufferedReader(fileReader);
		char [] parse = {' '};
		String delims = new String(parse);
		String line = input.readLine();
		//System.out.println(line);
        String [] lineWords = line.split(delims);
        for(int i=0;i<lineWords.length;i++)
        {
            //System.out.println(lineWords[i]);
            if(Tobj.getPayeeName().equalsIgnoreCase(lineWords[i]))
            {
            	System.out.println("Name found in Sanctions list");
            	throw new Exceptions("Payee Name in sanctions list");
            }
        }
	}
	
	void checkValidCountry() throws Exceptions {
		Country cc=new Country( null);
		System.out.println("in country vala");
		countries=cc.liistofCountries();
		if(!countries.contains(Tobj.getCntry())) {
			throw new Exceptions("Invalid Country");
		}
	}
	public void checkBanCountry() throws IOException, Exceptions{
		File file = new File("C:\\Users\\nigudkar\\Desktop\\CitiProj\\github\\CitiBridge-project\\Ban_Countries.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader input = new BufferedReader(fileReader);
		char [] parse = {' '};
		String delims = new String(parse);
		String line = input.readLine();
		//System.out.println(line);
        String [] lineWords = line.split(delims);
        for(int i=0;i<lineWords.length;i++)
        {
           	//System.out.println(lineWords[i]);
           	if(Tobj.getCntry().equalsIgnoreCase(lineWords[i]))
            {
            	System.out.println("Country found in Banned list");
            	throw new Exceptions("Country found in Banned list");
            }
        }	
	}
		
	
}
