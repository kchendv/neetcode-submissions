/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (fast != null) {
            slow = slow?.next
            fast = fast?.next?.next
            if (slow == fast && slow != null) {
                return true
            }
        }
        return false
    }
}
