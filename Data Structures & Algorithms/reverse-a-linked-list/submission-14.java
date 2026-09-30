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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

        }
    }
    /*
    1 -> 2 -> 3 -> 4
pr  cr
    null <- 1 XXXXXX 2 -> 3 -> 4
            pr       cr
    null <- 1 <- 2 XXXX 3 -> 4
                 pr     cr
    null <- 1 <- 2 <-3 XXXX 4 -> null
                     pr     cr
    null <- 1 <-2 <-3 <-4
                        pr cr

    */

