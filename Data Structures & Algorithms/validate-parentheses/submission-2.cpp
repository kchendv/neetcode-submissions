class Solution {
public:
    bool isValid(string s) {
        std::vector<char> bstack;
        for (int i = 0; i< s.size(); i++) {
            if (s.at(i) == '(' || s.at(i) == '[' || s.at(i) == '{') {
                bstack.push_back(s.at(i));
            } else {
                if (bstack.empty()) {
                    return false;
                }
                char last = bstack.back();
                bstack.pop_back();
                if (last == '(' && s.at(i) != ')') {
                    return false;
                }
                if (last == '[' && s.at(i) != ']') {
                    return false;
                }
                if (last == '{' && s.at(i) != '}') {
                    return false;
                }
            }
        }
        return bstack.empty();
    }
};
