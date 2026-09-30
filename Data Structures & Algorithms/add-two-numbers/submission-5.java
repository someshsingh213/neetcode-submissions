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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String n1 = "";
        while(l1!=null){
            n1 = n1+l1.val;
            l1 = l1.next;
        }
        String n1Reverse = "";
        for(int i = 0; i<n1.length(); i++){
            n1Reverse = n1.charAt(i) + n1Reverse;
        }
        n1 = n1Reverse;

        int num1 = Integer.parseInt(n1);

        String n2 = "";
        while(l2!=null){
            n2 = n2+l2.val;
            l2 = l2.next;
        }

        String n2Reverse = "";
        for(int i = 0; i<n2.length(); i++){
            n2Reverse = n2.charAt(i) + n2Reverse;
        }
        n2 = n2Reverse;
        int num2 = Integer.parseInt(n2);

        int sum = num1 + num2;

        if(sum == 0){
            return new ListNode(0);
        }

        ListNode list = null;
        ListNode head = list;
        while(sum != 0){
            if(list == null){
                list = new ListNode(sum%10);
                head = list;
                sum = sum/10;
            } else {
                ListNode newNode = new ListNode(sum%10);
            list.next = newNode;
            list = newNode;
            sum = sum/10;
            }
            
        }

        return head;
    }
}
