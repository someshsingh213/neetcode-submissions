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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode curr2 = head;
        
        
        int len = 0;
        while(curr2!=null){
            curr2 = curr2.next;
            len++;
        }

        int i = 0;
        int fromBegin = len - n + 1;
        ListNode curr = head;
        ListNode prev = null;
        while(i < fromBegin - 1){
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(prev == null){
            prev = curr;
            curr = curr.next;
            return curr;
        } else {

        }
        prev.next = curr.next;
        return head;
    }
}
