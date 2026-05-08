/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private data class Ans(
        val md: Int,
        val sa: Int,
    )
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val fa = helper(root)
        return maxOf(fa.md - 1, fa.sa)
    }
    private fun helper(root: TreeNode?): Ans {
        if (root == null) {
            return Ans(0,0)
        }
        val la = helper(root.left)
        val ra = helper(root.right)
        return Ans(maxOf(la.md, ra.md) + 1, maxOf(la.sa, ra.sa, la.md+ra.md))
    }
}
