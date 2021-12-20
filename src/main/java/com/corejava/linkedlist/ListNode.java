package com.corejava.linkedlist;

public class ListNode {
	
	private int data;
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	private ListNode next;
	
	public ListNode(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.next = null;
	}

}
