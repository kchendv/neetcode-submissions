class Solution {
    public int hammingWeight(int n) {
        int t = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                t++;
            } 
            n = n >> 1;
        }
        return t;
    }
}
