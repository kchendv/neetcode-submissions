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
    public int diameterOfBinaryTree(TreeNode root) {
        // ret maxDepth, subAnswer
        
        Pair<Integer, Integer> fa = helper(root);
        return Math.max(fa.getKey(), fa.getValue());
    }
    public Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) {
            return new Pair(-1,0);
        }
        Pair<Integer, Integer> la = helper(root.left);
        Pair<Integer, Integer> ra = helper(root.right);
        int md = (Math.max(la.getKey(), ra.getKey()) + 1);
        int sa = (Math.max(la.getValue(), ra.getValue()));
        int sah = 0;
        if (la.getKey() != -1) {
            sah += la.getKey() + 1;
        }
        if (ra.getKey() != -1) {
            sah += ra.getKey() + 1;
        }
        sa = Math.max(sa, sah);
        return new Pair(md, sa);
    }
}
