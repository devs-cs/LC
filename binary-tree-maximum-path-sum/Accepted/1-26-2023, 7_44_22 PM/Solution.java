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
class Solution {
    public int maxPathSum(TreeNode root) {
        return recur(root)[0];
    }

    private int[] recur(TreeNode node)
    {

        int[] p1, p2;
        int maxEndsHere = 0;
        int max = 0;
        if (node.left != null&& node.right != null)
        {
            p1 = recur(node.left);
            p2 = recur(node.right);
            max = Math.max(p1[0], p2[0]);
            max = Math.max(max, p1[1] + p2[1] + node.val);
            maxEndsHere = node.val;
            maxEndsHere = Math.max(p1[1] + node.val, maxEndsHere);
            maxEndsHere = Math.max(p2[1] + node.val, maxEndsHere);
            max = Math.max(max, maxEndsHere);
        }
        else if (node.left != null)
        {
            p1 = recur(node.left);
            max = p1[0];
            maxEndsHere = p1[1] + node.val;
            maxEndsHere = Math.max(maxEndsHere, node.val);
            max = Math.max(max, maxEndsHere);
        }
        else if (node.right != null)
        {
            p2 = recur(node.right);
            max = p2[0];
            maxEndsHere = p2[1] + node.val;
            maxEndsHere = Math.max(maxEndsHere, node.val);
            max = Math.max(max, maxEndsHere);
        }
        else
        { 
            max = node.val;
            maxEndsHere = node.val;
        }
        return (new int[]{max, maxEndsHere});
    }


}