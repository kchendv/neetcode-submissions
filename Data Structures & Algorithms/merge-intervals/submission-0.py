class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # Sort by start
        # If A.end >= B.start, there is overlap
        # For every interval, take or expand
        ans = []
        intervals.sort()
        for i in range(len(intervals)):
            # Check if next one is overlapping
            if (i < len(intervals) - 1) and (intervals[i][1] >= intervals[i+1][0]):
                # Expand the next one so it encompasses the current one
                intervals[i+1][0] = intervals[i][0]
                intervals[i+1][1] = max(intervals[i+1][1], intervals[i][1])
            else:
                ans.append(intervals[i])
        return ans