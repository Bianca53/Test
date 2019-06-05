package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListManager {
	//List<No> list = new ArrayList<No>();
	No head;
	No last;
	
	public void insertInTheEnd(No no) {
		//if the list is empty
		if (this.head == null) {
			this.head = no;
			this.last = no;
			this.last.setBefore(head);
		} else { // insert in the end
			last.setAfter(no);
			no.setBefore(last);
			last = no;
		}
	}
	
	public void printOutList() {
		No aux = head;
		while (aux != null) {
			System.out.println("No = " + aux.getValue());
			aux = aux.getAfter();
		}
	}
	
	public void deleteInTheMiddle() {
		int listSize = 0;
		int count = 0;
		No aux = head;
			
		//Get the size of the list
		while (aux != null) {
			listSize++;
			aux = aux.getAfter();
		}
		
		aux = head;
		
		while (head != null) {
			if (count == (listSize/2)) {
				head.getBefore().setAfter(head.getAfter());;
				head.getAfter().setBefore(head.getBefore());				
			}
			head = head.getAfter();
			count++;
		}
		
		head = aux;
	}
}
