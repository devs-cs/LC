// https://leetcode.com/problems/binary-tree-maximum-path-sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //ok so we have two stores per node, largest path from below that ends there, and then largest path below
class Pair
{
    public int maxEnds, max;
    public Pair(int a, int b)
    {
        max = a;
        maxEnds = b;
    }
}
class Solution {
    public int maxPathSum(TreeNode root) {
        return recur(root).max;
    }
    private Pair recur(TreeNode node)
    {
        Pair p1 = null;
        Pair p2 = null;
        if(node.left != null)
            p1 = recur(node.left);
        if(node.right != null)
            p2 = recur(node.right);
        int maxEndsHere = 0;
        int max = 0;
        if (p1 != null && p2 != null)
        {
            max = Math.max(p1.max, p2.max);
            max = Math.max(max, p1.maxEnds + p2.maxEnds + node.val);
            maxEndsHere = node.val;
            maxEndsHere = Math.max(p1.maxEnds + node.val, maxEndsHere);
            maxEndsHere = Math.max(p2.maxEnds + node.val, maxEndsHere);
            max = Math.max(max, maxEndsHere);
        }
        else if (p1 != null)
        {
          
            max = p1.max;
            maxEndsHere = p1.maxEnds + node.val;
            maxEndsHere = Math.max(maxEndsHere, node.val);
            max = Math.max(max, maxEndsHere);
        }
        else if (p2 != null)
        {
            
            max = p2.max;
            maxEndsHere = p2.maxEnds + node.val;
            maxEndsHere = Math.max(maxEndsHere, node.val);
            max = Math.max(max, maxEndsHere);
        }
        else
        { 
            max = node.val;
            maxEndsHere = node.val;
        }
        return new Pair(max, maxEndsHere);
    }


}