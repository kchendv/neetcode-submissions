/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        Ans fa = helper(root);
        return max(fa.md-1, fa.sa);
    }

private:
    class Ans {
        public: 
            int md;
            int sa;
            Ans(int x, int y): md(x), sa(y) {
                
            };
    };

    Ans helper(TreeNode* root) {
        if (root == nullptr) {
            return Ans(0,0);
        }
        Ans la = helper(root->left);
        Ans ra = helper(root->right);
        return Ans(max(la.md, ra.md) + 1, max(max(la.sa, ra.sa), la.md+ra.md));
    }
};
