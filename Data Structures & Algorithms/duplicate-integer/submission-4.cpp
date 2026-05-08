class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        set<int> hasSeen;
        for(int num: nums) {
            if (hasSeen.contains(num)) {
                return true;
            } else {
                hasSeen.insert(num);
            }
        }
        return false;
    }
};