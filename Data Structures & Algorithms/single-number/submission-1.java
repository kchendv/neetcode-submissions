class Solution {
    public int singleNumber(int[] nums) {
        int t = 0;
        for (int i: nums) {
            t = t ^ i;
        }
        return t;
    }
}
