package quodvide;


import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * Definition for singly-linked list.
 */
public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        printNode(mergeKLists(new ListNode[]{first, second, third}));
    }

    private static void printNode(ListNode mergeKLists) {
        while (mergeKLists != null) {
            System.out.print(" " + mergeKLists.val);
            mergeKLists = mergeKLists.next;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if(isEmptyAll(lists)) {
            System.out.println("It's null");
            return null;
        }
        int index = findMinIndex(lists);
        ListNode result = new ListNode(lists[index].val);
        ListNode target = result;
        lists[index] = lists[index].next;
        while (!isEmptyAll(lists)) {
            index = findMinIndex(lists);
            System.out.println("index = " + index);
            target.next = new ListNode(lists[index].val);
            target = target.next;
            lists[index] = lists[index].next;
        }
        return result;
    }

    private static int findMinIndex(ListNode[] lists) {
        int index = 0;
        int val = Integer.MAX_VALUE;
        ListNode tmp;
        for (int i = 0; i < lists.length; i++) {
            tmp = lists[i];
            if(tmp != null && val > tmp.val) {
                val = tmp.val;
                index = i;
            }
        }

        return index;
    }


    private static boolean isEmptyAll(ListNode[] lists) {
        for (ListNode n : lists) {
            if (n != null) return false;
        }

        return true;
    }
}
