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
        ListNode res = new ListNode();
        ListNode curr = res;
        PriorityQueue<ListNode> minHeap =
    new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(int i = 0; i<lists.length; i++){
            if(lists[i]!=null){
                minHeap.offer(lists[i]);
            }
        }

        while(minHeap.size()!=0){
            ListNode node= minHeap.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next!=null){
                minHeap.offer(node.next);
            }
        }
        
        return res.next;
    }
}
