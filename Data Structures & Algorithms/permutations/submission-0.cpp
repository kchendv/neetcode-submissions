class Solution {
public:
    map<vector<int>,vector<vector<int>>> memo;

    vector<vector<int>> permute(vector<int>& nums) {
        if (nums.empty()) {
            return vector<vector<int>> {vector<int>{}};
        }
        if (memo.find(nums) != memo.end()) {
            return memo[nums];
        }
        vector<vector<int>> ans;
        for (int i = 0; i < nums.size(); i++) {
            vector<int> ccopy = nums;
            ccopy.erase(ccopy.begin() + i);
            vector<vector<int>> permuted = permute(ccopy);
            for (vector<int> p: permuted) {
                p.push_back(nums[i]);
                ans.push_back(p);
            }
        }
        memo[nums] = ans;
        return ans;
    }
};
