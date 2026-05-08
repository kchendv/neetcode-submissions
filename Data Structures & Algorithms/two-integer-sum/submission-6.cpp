class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> x;
        int comp;
        for (int i = 0; i < nums.size(); i++) {
            comp = target - nums[i];
            auto rit = x.find(comp);
            if (rit != x.end()) {
                return vector<int>{rit->second , i};
            }
            x[nums[i]] = i;
        }
        
    }
};
