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

        /*
        Think of this like this:
        1. At every run of the loop, the list will be broken
        2. Initially prev = null, curr = first node

        3. You reverse first's link = "curr.next = prev"
        4. Then you name prev = curr;
        5. curr = temp; WHERE TEMP WAS the original curr.next before changing it to prev
        6. At every loop-run, curr is the node whose link has to be revered and it is broken from prev
        7. At every loop-run, prev is the node which is the last node of the reveresed list and you need to point curr to prev i.e curr.next = prev you have to do
        */
    
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

