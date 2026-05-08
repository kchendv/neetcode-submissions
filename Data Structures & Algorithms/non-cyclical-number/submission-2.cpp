class Solution {
public:
    bool isHappy(int n) {
        set<int> seen;
        int cur = n;
        while (true) {
            if (cur == 1) {
                return true;
            }
            if (seen.contains(cur)) {
                return false;
            }
            seen.insert(cur);
            cur = ssd(cur);
        }
    }

    int ssd(int n) {
        int dig = 0;
        int summ = 0;
        while (n > 0) {
            dig = n % 10;
            summ += (dig * dig);
            n /= 10;
        }
        return summ;
    }
};
