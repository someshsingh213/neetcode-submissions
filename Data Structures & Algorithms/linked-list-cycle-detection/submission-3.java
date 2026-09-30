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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head.next;

        while(fast != null){
            if(fast == head) {
                return true;
            } else {
                if(fast.next == null){
                    break;
                }
                fast = fast.next.next;
                head = head.next;
            }
        }
        return false;
    }
}
