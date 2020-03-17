package com.example.demo;

import java.util.ArrayList;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.Transaction;

@Repository
public class Controller {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	Controller aaa;
	public ArrayList<String> getNames()
	{
		ArrayList<String> Uname=new ArrayList<String>();
		Uname.addAll(jdbctemplate.queryForList("select Amt from validatePass;", String.class));
		//jdbctemplate.q
		return Uname;
	}
	@GetMapping(path="/names")
	public ArrayList<String> bbb()
	{
		return aaa.getNames();
	}
	
	public void insertIntoDB(Transaction Tobj,String tbn) throws Exceptions
	{
		try { 
			String url = "jdbc:mysql://localhost:3306/db"; 
	        Connection conn = DriverManager.getConnection(url,"root","saphana12##"); 
	        if(Tobj.getEC()==1) {
	        	String sql ="INSERT INTO "+tbn+"(TransactionRef,ValueDate,PayerName,PayerAcc,PayeeName,PayeeAcc,Amt,Status)VALUES(?,?,?,?,?,?,?,?)";
		        
		        PreparedStatement pstmt = conn.prepareStatement(sql); {
		        	pstmt.setString(1, Tobj.getTransRef());
		            pstmt.setString(2, Tobj.getDate());
		            pstmt.setString(3, Tobj.getPayerName());
		            pstmt.setString(4,Tobj.getPayerAcc());
		            pstmt.setString(5, Tobj.getPayeeName());
		            pstmt.setString(6, Tobj.getPayeeAcc());
		            pstmt.setFloat(7, Tobj.getAmount());
		            pstmt.setString(8, "VP");
		            pstmt.executeUpdate();
		            }
	        }
	        else {
	        	System.out.println(Tobj.getReason()+"Reasoonnnnn");
	        	String sql2 ="INSERT INTO validateFail (TransactionRef,ValueDate,PayerName,PayerAcc,PayeeName,PayeeAcc,Amt,Status)VALUES(?,?,?,?,?,?,?,?)";
		        PreparedStatement pstmt2 = conn.prepareStatement(sql2); {
		        	pstmt2.setString(1, Tobj.getTransRef());
		        	pstmt2.setString(2, Tobj.getDate());
		        	pstmt2.setString(3, Tobj.getPayerName());
		        	pstmt2.setString(4,Tobj.getPayerAcc());
		        	pstmt2.setString(5, Tobj.getPayeeName());
		        	pstmt2.setString(6, Tobj.getPayeeAcc());
		        	pstmt2.setFloat(7, Tobj.getAmount());
		        	pstmt2.setString(8, Tobj.getReason());
		        	pstmt2.executeUpdate();
		            }
	        }
	        
	        
	        
	        Tobj.setEC(1);
            System.out.println("Doneeeeeeeeeeeeeee");
           
        } catch (Exception e) { 
            System.err.println("Got an SQL exception! "+e); 
            String ss=e.getMessage();
            Tobj.setEC(3);
            throw new Exceptions(ss);
        } 
		
		
		
		
	}		
}
