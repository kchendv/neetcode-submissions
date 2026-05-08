class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 2) {
            return Arrays.stream(cost).min().getAsInt();
        }
        int t1 = cost[n-1];
        int t2 = cost[n-2];
        int ind = n-2;
        while (ind > 0) {
            int x = cost[ind - 1] + Math.min(t1, t2);
            t1 = t2;
            t2 = x;
            ind--;
        }
        return Math.min(t1, t2);
    }
}
