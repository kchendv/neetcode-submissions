/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    bool hasCycle(ListNode* head) {
        set<ListNode*> seen;
        while (head != nullptr) {
            if (find(seen.begin(), seen.end(), head) != seen.end()) {
                return true;
            } else {
                seen.insert(head);
                head = head->next;
            }
        }
        return false;
    }
};
