package quodvide;

public class AddTwoNumber {
    public static void main(String[] args) {
        // 243 564
        AddTwoNumber one = new AddTwoNumber();
        ListNode first = new ListNode(8);
        first.next = new ListNode(9);
        first.next.next = new ListNode(9);

        ListNode second = new ListNode(2);
        second.next = new ListNode(6);
        second.next.next = new ListNode(5);
        System.out.println("First : " + first);
        System.out.println("Second : " + second);

        System.out.println(one.addTwoNumbers(first, second));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addedNode = addNodes(l1, l2);

        while(haveToRoundingUp(addedNode)) {
            addedNode = roundingUp(addedNode);
        }

        return addedNode;
    }

    private ListNode roundingUp(ListNode addedNode) {
        ListNode curr = addedNode;
        ListNode next = addedNode.next;

        while(next != null) {
            if(curr.val >= 10) {
                next.val += 1;
                curr.val -= 10;
            }

            curr = next;
            next = next.next;
        }

        if(curr.val >= 10) {
            curr.next = new ListNode(1);
            curr.val -= 10;
        }

        return addedNode;
    }

    private boolean haveToRoundingUp(ListNode addedNode) {
        if(addedNode.val >= 10) return true;
        while(addedNode.next != null) {
            addedNode = addedNode.next;
            if(addedNode.val >= 10) return true;
        }

        return false;
    }

    private ListNode addNodes(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode defaultNode = new ListNode(0);
        while(l1.next != null || l2.next != null) {
            if(l1.next == null) {
                l1 = defaultNode;
            } else {
                l1 = l1.next;
            }
            if(l2.next == null) {
                l2 = defaultNode;
            } else {
                l2 = l2.next;
            }

            add(result, l1.val + l2.val);
        }

        return result;
    }

    private void add(ListNode result, int i) {
        while(result.next != null) {
            result = result.next;
        }

        result.next = new ListNode(i);
    }
}