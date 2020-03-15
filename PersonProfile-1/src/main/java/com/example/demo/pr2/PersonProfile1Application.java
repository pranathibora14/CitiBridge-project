package com.example.demo.pr2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Lala.Lala;
import com.example.demo.pr2.controller.Controller;

@SpringBootApplication
public class PersonProfile1Application {

	public static void main(String[] args) throws IOException{
		Controller c=new Controller();
		Lala main = new Lala();
        main.start();
//        ArrayList<Word> aa =new ArrayList<>();
//        aa=main.printWords();
        //c.insertIntoDB();
		SpringApplication.run(PersonProfile1Application.class, args);
		
	}
	

}
