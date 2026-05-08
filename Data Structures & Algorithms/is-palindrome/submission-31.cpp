class Solution {
public:
    bool isPalindrome(string s) {
        std::vector<char> sf;
        for(int i = 0; i < s.length(); i++) {
            if(int(s.at(i)) >= 97 && int(s.at(i)) <= 122) {
                sf.push_back(s.at(i));
            } else if (int(s.at(i)) >= 48 && int(s.at(i)) <= 57) {
                sf.push_back(s.at(i));
            } else if (int(s.at(i)) >= 65 && int(s.at(i)) <= 90) {
                sf.push_back(s.at(i)+32);
            }    
        }

        if (sf.size() == 0) {
            return true;
        }
        for (int j = 0; j <= (sf.size() / 2); j++) {
            if (sf[j] != sf[sf.size() - j - 1]) {
                return false;
            }
        }
        return true;
    }
};
