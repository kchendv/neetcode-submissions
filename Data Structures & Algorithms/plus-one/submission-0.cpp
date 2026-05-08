class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int x = digits.size() - 1;
        bool haveInc = true;
        while (x >= 0 && haveInc) {
            digits[x] ++;
            if (digits[x] == 10) {
                digits[x] = 0;
                haveInc = true;
            } else {
                haveInc = false;
            }
            x--;
        }
        if (haveInc) {
            digits.insert(digits.begin(), 1);
        }
        return digits;
    }
};
