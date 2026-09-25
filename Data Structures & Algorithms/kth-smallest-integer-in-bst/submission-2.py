# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Order = base given + left tree size
        return self.helper(root, k)[1]

    def helper(self, root, target):
        if root == None:
            return (False, 0)
        
        (lfound, ln) = self.helper(root.left, target)
        if lfound:
            return (True, ln)
        (rfound, rn) = self.helper(root.right, target - ln - 1)
        if rfound:
            return (True, rn)
        
        if ln == target - 1:
            return (True, root.val)
        return (False, ln + rn + 1)
        
