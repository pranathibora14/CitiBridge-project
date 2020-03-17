package com.example.demo;

import java.util.ArrayList;
import java.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	public void insertIntoDB(Transaction Tobj,String tbn)
	{

		
		try { 
	       // System.out.println("float vala" +Tobj.getAmount());
			String url = "jdbc:mysql://localhost:3306/db"; 
	        Connection conn = DriverManager.getConnection(url,"root","saphana12##"); 
	        Statement st = conn.createStatement(); 
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
	        

            System.out.println("Doneeeeeeeeeeeeeee");
           
        } catch (Exception e) { 
        	int j=0;
            System.err.println("Got an exception! "+e); 
            Controller cc=new Controller();
//            if(j==0) {
//            	cc.insertIntoDB(Tobj,"validateFail");
//            	j=1;
//            }
            
            
        } 
		
		
		
		
	}		
}
