/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var last: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = last
            last = cur
            cur = next
        }
        return last

    }
}
