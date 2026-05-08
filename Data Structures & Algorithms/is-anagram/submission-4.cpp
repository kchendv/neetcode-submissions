class Solution {
public:
    bool isAnagram(string s, string t) {
        int ts = t.size();
        int ss = s.size();
        if (ts != ss) {
            return false;
        }
        int cs[26] = {};
        
        for (int i = 0; i < ss; i++) {
            cs[s[i] - 'a']++;
            cs[t[i] - 'a']--;
        }
        for (int i: cs) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
};
