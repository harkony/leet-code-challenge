package harkony.weekly.week9;

import java.util.*;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (ListNode node : lists) {
            while (node != null) {
                Integer count = map.get(node.val);
                if (count == null)
                    count=0;
                count+=1;
                map.put(node.val, count);
                node = node.next;
            }
        }
        Iterator<Integer> treeMapIter = map.keySet().iterator();
        ListNode head = null;
        ListNode previous = null;
        while (treeMapIter.hasNext()) {
            Integer key = treeMapIter.next();
            Integer value = map.get(key);
            for (int i=0;i<value;i++) {
                ListNode node=new ListNode(key);
                if (head == null)
                    head = node;
                else
                    previous.next = node;

                previous = node;
            }
        }
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
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        ListNode seven = new ListNode(7);
        six.next = seven;

        ListNode[] lists = {one, four};
        System.out.println(mergeKLists(lists));
    }

}