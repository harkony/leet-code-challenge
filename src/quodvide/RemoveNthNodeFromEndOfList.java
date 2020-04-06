package quodvide;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);

        printNode(test);
        System.out.println();
        removeNthFromEnd(test, 4);

        printNode(test);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        if(n == 1 && length == 1) return null;
        return removeNthFromStart(head, length - n);
    }

    public static int getLength(ListNode a) {
        int length = 0;
        while (a != null) {
            length++;
            a = a.next;
        }
        return length;
    }

    public static ListNode removeNthFromStart(ListNode head, int n) {
        if(n == 0) return head.next;
        ListNode target = head;
        for (int i = 0; i < n - 1; i++) {
            target = target.next;
        }
        ListNode candidate = target.next.next;
        target.next = candidate;
        return head;
    }

    private static void printNode(ListNode test) {
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

