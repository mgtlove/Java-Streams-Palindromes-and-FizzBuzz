package com.collabera.example;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class HelloWordExample {

	public static void main(String[] args) throws IOException {
		//Number to test
		int num = 7;
		
		//Factorial
		int fact = factorial(num);
		System.out.println("Factorial " + num);
		System.out.println(fact);
		
		//Prime
		boolean prime = primeNumber(num);
		System.out.println(num + " is prime: " + prime);
		
		//FizzBuzz Class
		FizzBuzz test = new FizzBuzz(3, 9, 3*9, "fizz", "buzz", "fizzBuzz");
		test.fizzBuzz(1, 60);
		
		//Palindrome Test
		System.out.println(checkPalindrome("racecar"));
		System.out.println(isPalindrome("racecar"));
		
		//File Reverse Test
//		byte[] fileBeingRead= Files.readAllBytes(Paths.get("C:\\Java_WorkSpace\\Hello World\\src\\test.txt"));
//		String outputFile= new String(fileBeingRead);
//		System.out.println(outputFile);
//		System.out.println(reverseFile(fileBeingRead));
		
		//Stream Reverse File
		File file = new File("C:\\\\Java_WorkSpace\\\\Hello World\\\\src\\\\test.txt");
		
		ByteBuffer fileBB = ByteBuffer.wrap(Files.readAllBytes(file.toPath()));
		byte[] destination = new byte[fileBB.array().length]; 

		List<ByteBuffer> list = Arrays.asList(fileBB.position(fileBB.array().length).rewind())
			.stream().map(m -> m.get(destination)).collect(toList());
		
	
	}
	
	public static int factorial(int number) {
		if(number >= 1) {
			return number * factorial(number-1);
		}
		else return 1;
	}
	
	public static boolean primeNumber(int number) {
		if(number <= 1) return false;
		for (int n = 2; n < number; n++) {
			if (multiples(number, n)) return false;
		}
		return true;
	}
	
	public static boolean multiples(int dividend, int divisor) {
		if(dividend % divisor == 0) return true;
		else return false;
	}
	
	public static boolean checkPalindrome(String input) {
		int halfLength = (input.length())/2; 
		int midpoint = (halfLength);
		String firstHalf = input.substring(0, midpoint);
		StringBuilder secondHalf;
		
		if (input.length() % 2 != 0) {
			midpoint = (halfLength + 1);
		}
			
		secondHalf = new StringBuilder(input
				.substring((midpoint), (input.length()))).reverse();
		if(firstHalf.equalsIgnoreCase(secondHalf.toString())) {
			System.out.println(firstHalf);
			System.out.println(secondHalf);
			return true;
		}
		System.out.println(firstHalf);
		System.out.println(secondHalf);
		return false;
	}
	
	public static String reverseFile(byte[] fileIn) {
		StringBuilder reverseFile = new StringBuilder(new String(fileIn)).reverse();
		byte [] reverseFileBytes = reverseFile.toString().getBytes();
		System.out.println(reverseFileBytes.toString());
		return reverseFile.toString();
	} 
	
	public static boolean isPalindrome(String s) { 
		int length = s.length(); 
		for (int i = 0; i < (length/2); ++i) {
		 if (s.charAt(i) != s.charAt(length - i - 1)) { return false; } 
		}
		return true; 
	}
	
	public static HashMap<Integer, String> employeeEntries(int employeeCount){
		HashMap<Integer, String> employees = new HashMap<Integer, String>();
		for(int employee = 0; employee <= employeeCount; employeeCount++) {
			employees.put(employee, "data");
		}
		return employees;
	}

	
}
