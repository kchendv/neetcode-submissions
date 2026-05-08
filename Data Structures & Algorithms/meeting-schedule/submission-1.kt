/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val intervalsSorted = intervals.sortedBy {it.start}
        for (i in 1..intervalsSorted.size-1) {
            if (intervalsSorted[i].start < intervalsSorted[i-1].end) {
                return false
            }
        }
        return true
    }
}
