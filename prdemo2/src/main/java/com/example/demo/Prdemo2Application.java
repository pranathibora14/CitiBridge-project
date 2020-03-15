package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Lala.Word;

@SpringBootApplication
public class Prdemo2Application {

	public static void main(String[] args) throws IOException{
		Controller c=new Controller();
		Lala main = new Lala();
        main.start();
//        ArrayList<Word> aa =new ArrayList<>();
//        aa=main.printWords();
        //c.insertIntoDB();
		SpringApplication.run(Prdemo2Application.class, args);
		
	}
	

}
