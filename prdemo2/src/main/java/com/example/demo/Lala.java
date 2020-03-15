package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.example.demo.TransactionObject.Transaction;
import com.example.demo.TransactionObject.Validation;


public class Lala {
    private ArrayList<Word> words;
    public void start() throws IOException {
        readFile(); 
    }
 
    private void readFile()throws IOException{
    	File file = new File("C:\\Users\\nigudkar\\eclipse-workspace\\Hello\\src\\h\\h1\\Untitled 1");
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
            String [] xx =new String[10];
            for (int i = 0; i < lineWords.length; i++) {
                Word w = new Word(lineNum,lineWords[i]); 
                words.add(w);            
                String d=words.get(i).getName();
                xx[i]=d;
                
                
            }
            Transaction Tobj=new Transaction(xx[0],xx[1],xx[2],xx[3],xx[4],xx[5],Float.parseFloat(xx[6]));
            Validation v=new Validation(Tobj);
            System.out.println(Tobj.getDate());
            z=v.validateTransaction();
            System.out.println(Tobj.getDate());
            words.clear();
            if(z) {
            	cc.insertIntoDB(Tobj);
            }
            lineNum++;    
            line = input.readLine();
        }
        
    }
    
 
   
    class Word{
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
