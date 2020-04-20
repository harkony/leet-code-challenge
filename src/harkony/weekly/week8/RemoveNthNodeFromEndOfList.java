package harkony.weekly.week8;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // n th from tail = N-n th from head
        // N-n-1 -> N-n+1
        int N = 1;
        ListNode target = head;
        while (target.next != null) {
            N++;
            target = target.next;
        }
        if (N == n)
            return head.next;

        ListNode previous = head;
        for (int i = 0; i < N - n - 1; i++)
            previous = previous.next;

        ListNode next = head;
        for (int i = 0; i < N - n + 1; i++)
            next = next.next;

        previous.next = next;
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return val + (next != null ? " => " + next.toString() : "");
        }
    }


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        ListNode seven = new ListNode(7);
        six.next = seven;

        System.out.println(removeNthFromEnd(one, 7));
    }
}