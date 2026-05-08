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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        int pv;
        int qv;
        if (p->val < q->val) {
            pv = p->val;
            qv = q->val;
        } else {
            pv = q->val;
            qv = p->val;
        }
        while (root != nullptr) {
            bool a = root->val == pv || root->val > pv;
            bool b = root->val == qv || root->val < qv;
            if (a && b) {
                return root;
            }
            if (a) {
                root = root->left;
            } else {
                root = root->right;
            }
        }
        return nullptr;
    }
};
