class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int curN = n;
        while (true) {
            if (curN == 1) {
                return true;
            }
            if (seen.contains(curN)) {
                return false;
            }
            seen.add(curN);
            curN = ssd(curN);
        } 
    }

    private int ssd(int n) {
        int dig = 0;
        int summ = 0;
        while (n > 0) {
            dig = n % 10;
            summ += (dig * dig);
            n /= 10;
        }
        return summ;
    }
}
