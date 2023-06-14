// https://leetcode.com/problems/palindrome-linked-list

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
    public boolean isPalindrome(ListNode head) {
        ListNode priorNode = new ListNode(head.val);
        ListNode curNode = head.next;
        int counter = 1;
        ListNode newNode = new ListNode();
        while(curNode != null)
        {
            newNode = new ListNode(curNode.val, priorNode);
            priorNode = newNode;
            curNode = curNode.next;
            counter++;
        }
        /*while(newNode!= null)
        {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }*/
        //System.out.println(input);
       for(int i = 0; i < counter/2; i++)
        {
            if(head.val != newNode.val)
              return(false);
            head = head.next;
            newNode = newNode.next;
        }
        return(true);
    }
}