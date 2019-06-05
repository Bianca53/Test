package com.example;

public class No {
	private int value;
	private No before;
	private No after;
	
	public No getAfter() {
		return after;
	}
	public void setAfter(No after) {
		this.after = after;
	}
	public No getBefore() {
		return before;
	}
	public void setBefore(No before) {
		this.before = before;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
}
