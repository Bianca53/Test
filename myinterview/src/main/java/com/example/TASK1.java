package com.example;

/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
	public static void main(String[] args) {
		String word = "racecar";
   	 	if (isPalindrome(word)) {
   	 		System.out.println("It's Palindrome");
   	 	} else {
   	 		System.out.println("It is not Palindrome");
   	 	}
	}
		    
	public static boolean isPalindrome(String word) {
		String reversedWord = new StringBuffer(word).reverse().toString();
		if (word.equals(reversedWord)) {
			return true;
		} else {
			return false;
		}
	}


}
