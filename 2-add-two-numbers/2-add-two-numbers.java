/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultHead = new ListNode();
        ListNode current = resultHead;
        while (l1 !=null || l2!=null){
            int sum =  carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if(l2 != null) {
                sum += l2.val;
            }
            
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current.next = new ListNode(sum);
            
            if (l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            
            current = current.next;
        }
         if (carry > 0 ) {
            current.next = new ListNode(1);
        }
        return resultHead.next;
    }
}