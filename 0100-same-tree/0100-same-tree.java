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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null
        if (p == null && q == null) return true;

        // one null or values different
        if (p == null || q == null || p.val != q.val) return false;

        // check left and right
        return isSameTree(p.left, q.left) && 
               isSameTree(p.right, q.right);
    }
}