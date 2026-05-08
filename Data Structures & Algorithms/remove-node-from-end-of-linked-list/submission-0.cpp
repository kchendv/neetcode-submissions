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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* cur = head;
        int count = 0;
        while (cur != nullptr) {
            cur = cur-> next;
            count++;
        }
        if (n == count) {
            return head->next;
        }

        count = count - n - 1;
        cur = head;
        for (int i = 0; i < count; i++) {
            cur = cur->next;
        }
        cur->next = cur->next->next;
        return head; 
    }
};
