package com.corejava.linkedlist;

public class LinkedListReversal {
	public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }

   public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }
        ListNode node = reverseListRecursive(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }
}
