package com.example.demo.pr2.controller;
import com.example.demo.TransactionObject.*;
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
	
	public void insertIntoDB(Transaction Tobj)
	{
//		String url = "jdbc:mysql://localhost:3306/db"; 
//        Connection conn = DriverManager.getConnection(url,"root","saphana12##"); 
//        Statement st = conn.createStatement(); 
////		ArrayList<String> Uname=new ArrayList<String>();
////		Uname.addAll(jdbctemplate.queryForList("select PayerName from validatePass;", String.class));
//		//jdbctemplate.execute("INSERT INTO validatePass "+ "'Table'(TransactionRef ,ValueDate ,PayerName , PayerAcc , PayeeName , PayeeAcc , Amt , Status ) VALUES (127820252555,2018-01-02,FaLa,1553,Lula,20000102099,9999.90,NP)");
//		jdbctemplate.execute("INSERT INTO validatePass VALUES (127820252555,2018-01-02,FaLa,1553,Lula,20000102099,9999.90,NP)");

		//jdbctemplate.q
		
		
		try { 
	       // System.out.println("float vala" +Tobj.getAmount());
			String url = "jdbc:mysql://localhost:3306/db"; 
	        Connection conn = DriverManager.getConnection(url,"root","pranathibora14"); 
	        Statement st = conn.createStatement(); 
	        String sql ="INSERT INTO ValidatePass(TransactionRef,ValueDate,PayerName,PayerAcc,PayeeName,PayeeAcc,Amt,Status)VALUES(?,?,?,?,?,?,?,?)";
	        
//	        String q=lineWords[0];
//	        System.out.println(q);
//	        String w=lineWords[1];
//	        System.out.println(w);
//	        String e=lineWords[2];
//	        System.out.println(e);
//	        String r=lineWords[3];
//	        System.out.println(r);
//	        String t=lineWords[4];
//	        System.out.println(t);
//	        String y=lineWords[5];
//	        System.out.println(y);
//	        String u=lineWords[7];
//	        System.out.println(u);
	        
	        
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
	        
//            float amt=Float.parseFloat(lineWords[7].toString());  
//            System.out.println("float vala "+ amt +lineWords[0]);
	        //st.executeUpdate("INSERT INTO validatePass " +" VALUES (888,'2018-01-02','FaLa',1553,'Lula',20000102099,9999.90,'NP')");
           // st.executeUpdate("INSERT INTO validatePass " +" VALUES ('lineWords[0]',lineWords[1],'lineWords[2]','lineWords[3]','lineWords[4]','lineWords[5]',amt,'mb')");
            //st.executeUpdate("INSERT INTO validatePass(TransactionRef,ValueDate,PayerName,PayerAcc,PayeeName,PayeeAcc,Amt,Status)VALUES("+q+","+w+","+lineWords[2]+","+r+","+t+","+y+","+amt+","+u+")");
            //st.executeUpdate("INSERT INTO validatePass(TransactionRef,ValueDate,PayerName,PayerAcc,PayeeName,PayeeAcc,Amt,Status)VALUES(?,?,?,?,?,?,?,?)");
            System.out.println("Doneeeeeeeeeeeeeee");
           // conn.close(); 
        } catch (Exception e) { 
            System.err.println("Got an exception! "+e); 
            //System.err.println(e.getMessage()); 
        } 
		
		
		
		
	}		
}
//String q="ss"; //lineWords[0];
//String w="ss"; //lineWords[1];
//String e="ss"; //lineWords[2];
//String r="ss"; //lineWords[3];
//String t="ss"; //lineWords[4];
//String y="ss"; //lineWords[5];
//String u="ss"; //lineWords[7];