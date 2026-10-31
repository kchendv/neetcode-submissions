# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        stack = [(root, -math.inf, math.inf)]
        while stack:
            cur, l, r = stack.pop()
            if cur.val <= l or cur.val >= r:
                return False
            if cur.left:
                stack.append((cur.left, l, min(cur.val, r)))
            if cur.right:
                stack.append((cur.right, max(l, cur.val), r))
                


        return True