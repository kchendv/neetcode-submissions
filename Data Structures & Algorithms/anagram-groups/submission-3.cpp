class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string,vector<string>> x;
        for(auto s: strs) {
            string ss = s;
            sort(ss.begin(), ss.end());
            if (x.contains(ss)) {
                x[ss].push_back(s);
            } else {
                x[ss] = vector<string> {s};
            }
        }
        vector<vector<string>> f;
        for (auto const& [k,v]: x) {
            f.push_back(v);
        }
        return f;
    }
};
