// https://leetcode.com/problems/add-two-numbers

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
        ListNode curNode = new ListNode();
        ListNode pastNode = new ListNode();
        ListNode firstNode = new ListNode();
        boolean first = true;
        int car = 0;
        while(l1 != null || l2!=null)
        {
            
            if(l1 == null)
                l1 = new ListNode(0);
            else if (l2 == null)
                l2 = new ListNode(0);
            if(l1.val + l2.val +car >= 10)
            {
                curNode = new ListNode((l1.val + l2.val+car) %10); 
                car = 1;
            }
            else
            {
                curNode = new ListNode(l1.val + l2.val+car);
                car = 0;
            }
            if(first)
            {
                firstNode = curNode;
                first = false;
            }
            pastNode.next = curNode;
            pastNode = curNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (car == 1)
        {
            curNode = new ListNode(1);
            pastNode.next = curNode;
        }
        return(firstNode);
    }
}