class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0]; 

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > right) {
                right = piles[i];
            }
        }
        System.out.println(right);
        while (left < right) {
            int mid = (left + right) / 2;
            System.out.println(mid);
            int speed = getSpeed(piles, mid);
            
            System.out.println(speed);
            if (speed > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int getSpeed(int[] piles, int s) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            ans += Math.ceil(((double) piles[i]) / ((double) s));
            System.out.println(ans);
        }
        return ans;
    }
}
