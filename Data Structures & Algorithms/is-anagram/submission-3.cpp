class Solution {
public:
    bool isAnagram(string s, string t) {
        map<char, int> cs;
        for(char c: s) {
            cs[c] += 1;
        }
        for (char c: t) {
            cs[c] -= 1;
        }
        for (const auto& [key, value] : cs)  {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
};
