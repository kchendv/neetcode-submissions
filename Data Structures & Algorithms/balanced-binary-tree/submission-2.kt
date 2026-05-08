/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) != -1
    }
    fun height(root: TreeNode?): Int {
        if (root == null) { 
            return 0
        }
        val hl = height(root.left)
        val hr = height(root.right)
        if (hl == -1 || hr == -1 || abs(hl - hr) > 1) {
            return -1
        }
        return maxOf(hl, hr) + 1
    }
}
