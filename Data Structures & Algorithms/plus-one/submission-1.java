class Solution {
    public int[] plusOne(int[] digits) {
        int x = digits.length - 1;
        boolean hasInc = true;
        while (x >= 0 && hasInc) {
            if (digits[x] == 9) {
                digits[x] = 0;
                hasInc = true;
            } else {
                digits[x] ++;
                hasInc = false;
            }
            x--;
        }
        if (hasInc) {
            int[] newD = new int[digits.length + 1];
            newD[0] = 1;
            System.arraycopy(digits, 0, newD, 1, digits.length);
            return newD;
        }
        return digits;
    }
}
