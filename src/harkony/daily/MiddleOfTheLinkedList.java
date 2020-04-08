package harkony.daily;


import java.util.ArrayList;
import java.util.List;

/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode currentMiddle = head;
        ListNode node=head;
        int count=1;
        while (node != null) {
            if(count%2==0)
                currentMiddle=currentMiddle.next;
            node = node.next;
            count++;
        }
        return currentMiddle;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = new ListNode(3);
        b.next.next.next = new ListNode(4);
        System.out.println(middleNode(a) + "," + middleNode(b));
    }
}
