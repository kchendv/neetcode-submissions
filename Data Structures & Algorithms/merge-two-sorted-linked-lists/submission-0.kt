/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var h1 = list1
        var h2 = list2
        var m: ListNode? = ListNode(1)
        var h = m
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                m?.next = h2
                h2 = h2?.next
            } else if (h2 == null) {
                m?.next = h1
                h1 = h1?.next
            } else {
                if (h1.`val` > h2.`val`) {
                    m?.next = h2
                    h2 = h2?.next
                } else {
                    m?.next = h1
                    h1 = h1?.next
                }
            }
            m = m?.next
        }
        return h?.next
    }
}
