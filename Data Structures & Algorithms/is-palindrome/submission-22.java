class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sf = new StringBuilder("");
        s = s.toLowerCase();
        String alphaNumPattern = "[a-zA-Z0-9]+$";
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sf.append(c);
            }
        }
        String sfs = sf.toString();
        if (sfs.length() == 0) {
            return true;
        }
        for (int i = 0; i <= (sfs.length() / 2); i++) {
            if (sfs.charAt(i) != sfs.charAt(sfs.length() - i - 1)) {
                return false;
            }
        }
        return true;
        // for (int i = 0;)
    }
}
