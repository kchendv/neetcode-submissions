/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    data class SubResult(
        val isP: Boolean,
        val isQ: Boolean,
        val ans: TreeNode?,
    )

    var p: TreeNode? = null
    var q: TreeNode? = null

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        this.p = p
        this.q = q
        return helper(root).ans
    }

    fun helper(root:TreeNode?): SubResult {
        if (root == null) {
            return SubResult(false, false, null)
        }
        val lr = helper(root.right)
        if (lr.ans != null) {
            return lr
        }
        val ll = helper(root.left)
        if (ll.ans != null) {
            return ll
        }
        var isPFound = ll.isP || lr.isP || root.`val` == this.p?.`val`
        val isQFound = ll.isQ || lr.isQ || root.`val` == this.q?.`val`
        if (isPFound && isQFound) {
            return SubResult(true, true, root)
        }
        return SubResult(isPFound, isQFound, null)
    }
}
