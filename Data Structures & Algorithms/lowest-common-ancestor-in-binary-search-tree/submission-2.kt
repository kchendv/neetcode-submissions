/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cur = root
        var curVal = 0

        var pVal = p!!.`val`
        var qVal = q!!.`val`
        if (qVal < pVal) {
            val s = pVal
            pVal = qVal
            qVal = s
        }
        var isLeft = false
        var isRight = false
        while (cur != null) {
            curVal = cur.`val`
            isLeft = curVal == pVal || curVal > pVal
            isRight = curVal == qVal || curVal < qVal
            if (isLeft && isRight) {
                return cur
            } else if (isLeft) {
                cur = cur.left
            } else {
                cur = cur.right
            }
        }
        return null
    }
}
