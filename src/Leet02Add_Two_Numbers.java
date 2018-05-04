/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */


class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        this.val = x;
    }
}

public class Leet02Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null) {
            return null;
        }
        // don't change l1, l2
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyNode;
        int carry = 0;
        while (p != null || q!= null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;
    }

}
