class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1;
        int right = *std::max_element(piles.begin(), piles.end());
        while (left < right) {
            int mid = (left + right) / 2;
            int speed = getSpeed(piles, mid);
            if (speed > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    int getSpeed(vector<int>& piles, int s) {
        int ans = 0;
        for (int i = 0 ; i < piles.size(); i++) {
            ans += ceil(double(piles[i]) / double(s));
        }
        return ans;
    }
};
