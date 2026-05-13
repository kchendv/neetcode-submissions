class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        // Reverse flood fill
        int M = heights.size();
        int N = heights[0].size();
        vector<vector<bool>> p(M, vector<bool>(N, false));
        vector<vector<bool>> a(M, vector<bool>(N, false));
        vector<vector<int>> ans;
        vector<vector<int>> pq;
        vector<vector<int>> aq;
        for (int i = 0; i < M; i++) {
            pq.push_back(vector<int>{i, 0});
            aq.push_back(vector<int>{i, N-1});
        }
        for (int j = 0; j < N; j++) {
            pq.push_back(vector<int>{0, j});
            aq.push_back(vector<int>{M-1, j});
        }

        while (!pq.empty()) {
            vector<int> pp = pq.back();
            pq.pop_back();
            if (p[pp[0]][pp[1]] == false) {
                p[pp[0]][pp[1]] = true;
                if (pp[0] > 0 && heights[pp[0]-1][pp[1]] >= heights[pp[0]][pp[1]]) {
                    pq.push_back(vector<int>{pp[0]-1, pp[1]});
                }
                if (pp[0] < (M-1) && heights[pp[0]+1][pp[1]] >= heights[pp[0]][pp[1]]) {
                    pq.push_back(vector<int>{pp[0]+1, pp[1]});
                }
                
                if (pp[1] > 0 && heights[pp[0]][pp[1]-1] >= heights[pp[0]][pp[1]]) {
                    pq.push_back(vector<int>{pp[0], pp[1]-1});
                }
                
                if (pp[1] < (N-1) && heights[pp[0]][pp[1]+1] >= heights[pp[0]][pp[1]]) {
                    pq.push_back(vector<int>{pp[0], pp[1]+1});
                }
            }
        }

        
        while (!aq.empty()) {
            vector<int> aa = aq.back();
            aq.pop_back();
            if (a[aa[0]][aa[1]] == false) {
                a[aa[0]][aa[1]] = true;
                if (aa[0] > 0 && heights[aa[0]-1][aa[1]] >= heights[aa[0]][aa[1]]) {
                    aq.push_back(vector<int>{aa[0]-1, aa[1]});
                }
                if (aa[0] < (M-1) && heights[aa[0]+1][aa[1]] >= heights[aa[0]][aa[1]]) {
                    aq.push_back(vector<int>{aa[0]+1, aa[1]});
                }
                
                if (aa[1] > 0 && heights[aa[0]][aa[1]-1] >= heights[aa[0]][aa[1]]) {
                    aq.push_back(vector<int>{aa[0], aa[1]-1});
                }
                
                if (aa[1] < (N-1) && heights[aa[0]][aa[1]+1] >= heights[aa[0]][aa[1]]) {
                    aq.push_back(vector<int>{aa[0], aa[1]+1});
                }
            }
        }

        for (int i = 0; i< M; i++) {
            for (int j = 0; j < N; j++) {
                if (p[i][j] && a[i][j]) {
                    ans.push_back(vector<int>{i,j});
                }
            }
        }
        return ans;
    }
};
