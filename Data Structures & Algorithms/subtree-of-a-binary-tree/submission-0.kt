/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null) {
            return false
        }
        return isSametree(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }

    fun isSametree(ta: TreeNode?, tb: TreeNode?): Boolean {
        if (ta == null && tb == null) {
            return true
        }
        if (ta == null || tb == null) {
            return false
        }
        return ta.`val` == tb.`val` && isSametree(ta.left, tb.left) && isSametree(ta.right, tb.right)
    }
}
