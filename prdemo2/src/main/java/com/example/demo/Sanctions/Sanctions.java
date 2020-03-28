package com.example.demo.Sanctions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
	
	public void searchPayer() throws IOException, Exceptions{
		File file = new File("E:\\Github\\CitiBridge-project\\Sanctions_List.txt");
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
		File file = new File("E:\\Github\\CitiBridge-project\\Sanctions_List.txt");
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
		
	
}
