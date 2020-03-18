package com.example.demo.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.ExceptionHandling.Exceptions;
import com.example.demo.TransactionObject.Transaction;
import com.example.demo.TransactionObject.Validation;
import com.example.demo.controller.Controller;


public class ReadFile {
    private ArrayList<Word> words;
    public void start() throws IOException, Exceptions {
        readFile(); 
    }
 
    private void readFile()throws IOException,  Exceptions{
    	File file = new File("C:\\Users\\prana\\Downloads\\test.txt");
    	FileReader fileReader = new FileReader(file);
    	BufferedReader input = new BufferedReader(fileReader);
        words = new ArrayList<Word>();
        Controller cc=new Controller();
        int lineNum = 1;
        boolean z=false;
        char [] parse = {' '};
        String delims = new String(parse);
        String line = input.readLine();
        while(line != null){
            String [] lineWords = line.split(delims);
            String [] individualWords =new String[10];
            for (int i = 0; i < lineWords.length; i++) {
                Word w = new Word(lineNum,lineWords[i]); 
                words.add(w);            
                String d=words.get(i).getName();
                individualWords[i]=d;
                
                
            }
            Transaction Tobj=new Transaction(individualWords[0],individualWords[1],individualWords[2],individualWords[3],individualWords[4],individualWords[5],Float.parseFloat(individualWords[6]));
            Validation v=new Validation(Tobj);
            System.out.println(Tobj.getDate());
            z=v.validateTransaction();
            System.out.println(Tobj.getDate());
            words.clear();
            try {
            cc.insertIntoDB(Tobj);
            }
            catch (Exceptions e)
            {
            	System.out.println("Pass on exception to Angular: "+e);
    			//Here pass on Tobj to angular. We need to display Payer name, Payee Name, and Error Code. Error Code is a field of Tobj. 
    			//Check out Tobj.getEC() method for the error codes table.  
            }
            lineNum++;    
            line = input.readLine();
        } 
  
        
    }
  
    
    public class Word{
        private int lineNum;
        private String name;
 
        public Word(int lineNum,String name) {
            this.name = name;
        }
 
        public int getLineNum() {
            return lineNum;
        }
        public String getName() {
            return name;
        }    
    }    
}
