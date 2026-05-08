class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int l = prices.size();
        if (l == 0) {
            return 0;
        }
        vector<int> maxRight(l, 0);
        int curMax = prices[l-1];
        for (int i = 0; i < l; i++) {
            maxRight[l-1-i] = curMax;
            curMax = max(curMax, prices[l-1-i]);
        }
        int answer = 0;
        for (int i = 0; i < l; i++) {
            answer = max(answer, maxRight[i] - prices[i]);
        
        }
        return answer;
    }
};
