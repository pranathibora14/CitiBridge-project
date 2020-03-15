package com.example.demo.ExceptionHandling;

public class Exceptions extends Exception {
	String s1;
	public Exceptions(String s2)
	{
		s1=s2;
	}
	public String toString()
	{
		return "Exception occurred: "+s1;
	}
	
}