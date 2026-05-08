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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pv;
        int qv;
        if (p.val < q.val) {
            pv = p.val;
            qv = q.val;
        } else {
            pv = q.val;
            qv = p.val;
        }
        while (root != null) {
            boolean a = (root.val == pv || root.val > pv);
            boolean b = (root.val == qv || root.val < qv);
            if (a && b) {
                return root;
            }
            if (a) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
