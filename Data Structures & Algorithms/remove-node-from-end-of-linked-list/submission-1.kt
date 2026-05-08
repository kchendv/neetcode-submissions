/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var count = 0
        var cur: ListNode? = head
        while (cur != null) {
            cur = cur?.next
            count++
        }
        if (n == count) {
            return head?.next
        }
        cur = head
        count = count - n - 1
        for (i in 1..count) {
            cur = cur?.next
        }
        cur?.next = cur?.next?.next
        return head
    }
}
