class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        # Given A B, and A.start < B.start
        # If A.end > B.start then there is overlap
        # If there is overlap, greedily choose to remove the one which ends earlier

        take = 0
        curb = -50001
        for i in intervals:
            if i[0] >= curb:
                # No overlap, take and continue
                curb = i[1]
                take += 1
            else:
                # Has overlap, choose the one with the earlier exit to take
                curb = min(curb, i[1])
        return len(intervals) - take

                
        