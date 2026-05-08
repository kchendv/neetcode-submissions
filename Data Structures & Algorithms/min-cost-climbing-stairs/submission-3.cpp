class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        if (n <= 2) {
            auto min_it = std::min_element(cost.begin(), cost.end());
            int min_val = *min_it;
        }
        int t1 = cost[n-1];
        int t2 = cost[n-2];
        int ind = n-2;
        int x = 0;
        while (ind > 0) {
            x = cost[ind-1] + std::min(t1, t2);
            t1 = t2;
            t2 = x;
            ind--;
        }
        return std::min(t1, t2);
    }
};
