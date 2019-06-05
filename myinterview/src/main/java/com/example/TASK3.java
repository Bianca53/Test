package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
    public static void main(String[] args) {
      	 List<String> fruitList = new ArrayList<String>();
      	 List<String> auxList = new ArrayList<String>();
      	 int count = 0;
      	 
      	 fruitList.add("Apple");
      	 fruitList.add("Orange");
      	 fruitList.add("Apple");
      	 fruitList.add("Banana");
      	 fruitList.add("Pineapple");
      	 fruitList.add("Strawberry");
      	 fruitList.add("Apple");
      	 fruitList.add("Avocado");
      	 fruitList.add("Apple");
      	 fruitList.add("Apple");
      	 fruitList.add("Papaya");
      	 
      	 while (count < fruitList.size()) {   		 
      		 if (!auxList.contains(fruitList.get(count))) {
      			 auxList.add(fruitList.get(count));
      		 }   	 
      		 count ++;
      	 }   	 
      	 
      	 System.out.println("The total number of distinct itens is " + auxList.size());    
    }
	
	
}
