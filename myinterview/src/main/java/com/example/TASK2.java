package com.example;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 * 
 */
public class TASK2 {
	public static void main(String[] args) {
		ListManager list = new ListManager();
		No noA = new No();
		No noB = new No();
		No noC = new No();
		No noD = new No();
		
		noA.setValue(1);	
		noB.setValue(2);	
		noC.setValue(3);
		noD.setValue(4);
		
		list.insertInTheEnd(noA);
		list.insertInTheEnd(noB);
		list.insertInTheEnd(noC);
		list.insertInTheEnd(noD);
		
		System.out.println("Initial list:");
		list.printOutList();
		list.deleteInTheMiddle();
		System.out.println("Remove in the middle:");
		list.printOutList();
	}
}
