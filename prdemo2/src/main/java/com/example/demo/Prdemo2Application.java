package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Lala.Word;
import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.Transaction;

@SpringBootApplication
public class Prdemo2Application {

	public static void main(String[] args) throws IOException,Exceptions{
		Controller c=new Controller();
		Lala main = new Lala();
        main.start();
        Transaction tobj=new Transaction();
        tobj.getECTable();
		SpringApplication.run(Prdemo2Application.class, args);
		
	}
	

}
