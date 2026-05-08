class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        map<int, vector<Target>> x;
        for (vector<int> v: times) {
            if (x.find(v[0]) == x.end()) {
                x[v[0]] = vector<Target> { Target(v[1], v[2])};
            } else {
                x.find(v[0])->second.push_back( Target(v[1], v[2]));
            }
        }
        vector<int> mins(n, 1000000);
        deque<Target> targets { Target(k, 0)};
        while (!targets.empty()) {
            Target tx = targets.front();
            targets.pop_front();
            if (tx.t < mins[tx.v - 1]) {
                mins[tx.v - 1] = tx.t;
                if (x.find(tx.v) != x.end()) {
                    for (Target tt: x.find(tx.v)->second) {
                        targets.push_back(Target(tt.v, tt.t + tx.t));
                    }
                }
            }
        }
        if (find(mins.begin(), mins.end(), 1000000) != mins.end()) {
            return -1;
        }
        auto max_it = std::max_element(mins.begin(), mins.end());
        return *max_it;
    };
private:
    class Target {
        public:
        Target(int v, int t) {
            this->v = v;
            this->t = t;
        };
        int v;
        int t;
    };
};

