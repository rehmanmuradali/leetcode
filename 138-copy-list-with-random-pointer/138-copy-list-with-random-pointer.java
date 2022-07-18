/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        Node newHead = new Node(-1);
        Node currenNew = newHead;
        Map<Node, Node> nodesMap = new HashMap<>();

        while(current != null) {
            Node newNode = new Node(current.val);
            currenNew.next = newNode;
            nodesMap.put(current, newNode);
            currenNew = currenNew.next;
            current = current.next;
        }

        current = head;
        currenNew = newHead.next;
        while(current != null) {
            currenNew.random = nodesMap.get(current.random);
            currenNew = currenNew.next;
            current = current.next;
        }
        return newHead.next;
    }
}