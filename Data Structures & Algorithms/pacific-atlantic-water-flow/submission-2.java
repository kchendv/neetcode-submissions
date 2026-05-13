class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;
        boolean[][] at = new boolean[M][N];
        boolean[][] pt = new boolean[M][N];
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> aq = new ArrayList<>();
        List<List<Integer>> pq = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            pq.add(List.of(i, 0));
            aq.add(List.of(i, N-1));
        }
        for (int j = 0; j < N; j++) {
            pq.add(List.of(0, j));
            aq.add(List.of(M-1, j));
        }

        while (!pq.isEmpty()) {
            List<Integer> pp = pq.remove(pq.size() - 1);
            if (pt[pp.get(0)][pp.get(1)] == false ){
                pt[pp.get(0)][pp.get(1)] = true;
                int h = heights[pp.get(0)][pp.get(1)];
                if (pp.get(0) > 0 && heights[pp.get(0)-1][pp.get(1)] >= h) {
                    pq.add(List.of(pp.get(0)-1, pp.get(1)));
                }
                if (pp.get(0) < (M-1) && heights[pp.get(0)+1][pp.get(1)] >= h) {
                    pq.add(List.of(pp.get(0)+1, pp.get(1)));
                }
                if (pp.get(1) > 0 && heights[pp.get(0)][pp.get(1)-1] >= h) {
                    pq.add(List.of(pp.get(0), pp.get(1)-1));
                }
                if (pp.get(1) < (N-1) && heights[pp.get(0)][pp.get(1)+1] >= h) {
                    pq.add(List.of(pp.get(0), pp.get(1)+1));
                }
            }
        }
        
        while (!aq.isEmpty()) {
            List<Integer> aa = aq.remove(aq.size() - 1);
            if (at[aa.get(0)][aa.get(1)] == false ){
                at[aa.get(0)][aa.get(1)] = true;
                int h = heights[aa.get(0)][aa.get(1)];
                if (aa.get(0) > 0 && heights[aa.get(0)-1][aa.get(1)] >= h) {
                    aq.add(List.of(aa.get(0)-1, aa.get(1)));
                }
                if (aa.get(0) < (M-1) && heights[aa.get(0)+1][aa.get(1)] >= h) {
                    aq.add(List.of(aa.get(0)+1, aa.get(1)));
                }
                if (aa.get(1) > 0 && heights[aa.get(0)][aa.get(1)-1] >= h) {
                    aq.add(List.of(aa.get(0), aa.get(1)-1));
                }
                if (aa.get(1) < (N-1) && heights[aa.get(0)][aa.get(1)+1] >= h) {
                    aq.add(List.of(aa.get(0), aa.get(1)+1));
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j< N; j++) {
                if (at[i][j] && pt[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }
}
