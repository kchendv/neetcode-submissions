# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
    
        def helper(pl, pr, il, ir):
            if pl == pr:
                return None
            if pl + 1 == pr:
                return TreeNode(preorder[pl])
            
            root = TreeNode(preorder[pl])
            i = ir - 1
            while inorder[i] != preorder[pl]:
                i -= 1
            i = i - il
            if i > 0:
                root.left = helper(pl+1, pl+i+1, il, il+i)
            if pl + i <= pr:
                root.right = helper(pl+i+1, pr, il+i+1, ir)
            return root
        return helper(0, len(preorder), 0, len(inorder))