class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l == 0) {
            return 0;
        }
        int[] maxToTheRight = new int[l];
        int curMax = prices[l-1];
        for (int i = 0; i < l; i++) {
            maxToTheRight[l-i-1] = curMax;
            curMax = Math.max(curMax, prices[l-i-1]);
        }
        int answer = 0;
        for (int i = 0; i < l; i++) {
            answer = Math.max(answer, maxToTheRight[i] - prices[i]);
        }
        return answer;
    }
}
