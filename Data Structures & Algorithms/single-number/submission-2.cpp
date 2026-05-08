class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int j = 0;
        for (auto i: nums) {
            j = i ^ j;
        }
        return j;
    }
};
