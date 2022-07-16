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
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if ( k < 2) {
            return  head;
        }
        ///    1   2  3  4  5  6      C
        // P   S                      2
        //         E
        //            R
        //          |
        //     2   1| 3  4  5  6
        //     2   1  3  4  5  6
        //         S
        //         P
        //            S
        //            E                3
        //               E             4
        //                 |R
        //            4  3  R
        //               P  S
        ListNode prevStart = new ListNode();
        prevStart.next = head;
        ListNode start = head;
        ListNode end = head;
        int counter = 1;
        while(end !=null) {
            if (counter % k == 0) {
                ListNode remainingList = end.next;
                end.next = null;
                // link remaining list
                prevStart.next = reverseList(start);
                if(start == head){
                    head = end;
                }
                start.next = remainingList;
                prevStart = start;
                start = start.next;
                end = start;
                counter++;
            }
            else {
                counter++;
                end = end.next;
            }
        }
        return head;
    }


    // 1 2 3 4 5
    // P C N
    //   P C N
    //       P C N
    //         P C
    public static ListNode reverseList(ListNode head) {
        ListNode prev = head;
        if (prev == null) {
            return null;
        }
        ListNode current = prev.next;
        prev.next = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}