package harkony;

public class AddTwoNumber {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        //init
        int sum = getVal(l1) + getVal(l2) + carry;
        carry = sum / 10;
        int remain = sum % 10;
        ListNode root = new ListNode(remain);
        ListNode previous = root;
        l1 = getNext(l1);
        l2 = getNext(l2);

        while (true) {
            sum = getVal(l1) + getVal(l2) + carry;
            //escape case
            if (l1 == null && l2 == null && sum == 0)
                break;
            carry = sum / 10;
            remain = sum % 10;
            ListNode current = new ListNode(remain);
            previous.next = current;
            previous = current;
            l1 = getNext(l1);
            l2 = getNext(l2);
        }
        return root;
    }

    private static ListNode getNext(ListNode l) {
        if (l != null)
            return l.next;
        return null;
    }

    private static int getVal(ListNode l) {
        if (l == null)
            return 0;
        return l.val;

    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        l1.next = l2;
        l2.next = new ListNode(3);


        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(0);
        l4.next = l5;
        l5.next = new ListNode(4);


        ListNode result = addTwoNumbers(l1, l4);
        int a = result.val;
    }

}
