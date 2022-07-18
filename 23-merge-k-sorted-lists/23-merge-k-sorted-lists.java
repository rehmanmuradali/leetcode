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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));

        while(listNodes.size() > 1) {
            ListNode merged = mergeTwoLists(listNodes.get(0),listNodes.get(1));
            listNodes.remove(0);
            listNodes.remove(0);
            listNodes.add(merged);
        }
        return listNodes.size() > 0 ? listNodes.get(0) : null;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null){
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
            } else if(list2 != null) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        return result.next;
    }
}