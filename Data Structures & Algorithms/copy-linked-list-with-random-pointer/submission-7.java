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
        Node curr = head;
        if(head == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>(); //old node - new node
        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        Node newCurr = map.get(curr);
        while(curr != null){
            newCurr.next = map.get(curr.next);
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return map.get(head);
    }
}
