class Solution {
public:
    int climbStairs(int n) {
        int lastOne = 1;
        int lastTwo = 0;
        int currentWays = 1;
        int i = 1;
        while (i <= n) {
            currentWays = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = currentWays;
            i++;
        }
        return lastOne;
    }
};
