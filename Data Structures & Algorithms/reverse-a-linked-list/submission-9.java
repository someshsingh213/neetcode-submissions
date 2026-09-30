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

public class Solution {
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recurse on the rest of the list
        ListNode newHead = reverseList(head.next);

        // Reverse the link
        head.next.next = head;
        head.next = null;

        // Return new head from the deepest recursion
        return newHead;
    }
}