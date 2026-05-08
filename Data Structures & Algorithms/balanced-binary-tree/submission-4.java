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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        if (hl == -1 || hr == -1 || Math.abs(hr - hl) > 1) {
            return -1;
        }
        return Math.max(hr, hl) + 1;
    }
}
