class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int lastOne = 1;
        int lastTwo = 1;
        for (int i = 2; i <= n; i++) {
            int currentWays = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = currentWays;
        }
        return lastOne;
    }
}
