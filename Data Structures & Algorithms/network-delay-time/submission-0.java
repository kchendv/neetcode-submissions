class Solution {
    class Target {
        public Target(int v, int t) {
            this.v = v;
            this.t = t;
        }
        public int v;
        public int t;
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, ArrayList<Target>> timess = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            if (timess.containsKey(times[i][0])) {
                timess.get(times[i][0]).add(new Target(times[i][1], times[i][2]));
            } else {
                timess.put(times[i][0], new ArrayList<Target>(List.of(new Target(times[i][1], times[i][2]))));
            }
        }


        int[] mint = new int[n];
        Arrays.fill(mint, 1000000);
        // mint[k-1] = 1000000;
        ArrayList<Target> q = new ArrayList<>(List.of(new Target(k,0)));

        while (!q.isEmpty()) {
            Target tx = q.remove(q.size() - 1);
            if (tx.t < mint[tx.v - 1]) {
                mint[tx.v - 1] = tx.t;
                if (timess.containsKey(tx.v)) {
                    for (Target tt: timess.get(tx.v)) {
                        q.add(new Target(tt.v, tt.t + tx.t));
                    }
                }
            }
        }

        int maxi = 0;
        for (int mi: mint) {
            if (mi == 1000000) {
                return -1;
            } else if (mi > maxi) {
                maxi = mi;
            }
        }
        return maxi;
    }
}
