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
        
        ArrayList<Integer> input = new ArrayList<Integer>();
        while(head != null)
        {
            input.add(head.val);
            head = head.next;
        }
        //System.out.println(input);
        for(int i = 0; i < input.size(); i++)
        {
            if(input.get(i) != input.get(input.size() -i - 1))
                return(false);
        }
        return(true);
    }
}