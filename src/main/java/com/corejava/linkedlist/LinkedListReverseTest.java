package com.corejava.linkedlist;

import com.corejava.linkedlist.LinkedList.Node;

public class LinkedListReverseTest {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		Node h =list.head;
		print(list, h);
		reverseList(list);
		print(list, h);
	}

	private static void print(LinkedList list, Node h) {
		while(list.head != null) {
			System.out.print(" "+list.head.data);
			list.head = list.head.next;
		}
		list.head =h;
		System.out.println();
	}

	private static void reverseList(LinkedList list) {
		Node pre = null;
		Node current = list.head;
		Node next;
		while(current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		list.head = pre;
	}
	
}

class LinkedList {
	Node head;

	public static class Node {
		Node next;
		Object data;

		Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

}