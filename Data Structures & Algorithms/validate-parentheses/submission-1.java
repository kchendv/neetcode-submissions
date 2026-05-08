class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> bstack = new ArrayList<>();
        for (char c : s.toCharArray()) {
            System.out.println(bstack);
            if (c == '(' || c == '[' || c == '{') {
                bstack.add(c);
            } else {
                if (bstack.isEmpty()) {
                    return false;
                }
                
                char last = bstack.removeLast();
                if (c == ')' && last != '(') {
                    return false;
                }
                if (c == ']' && last != '[') {
                    return false;
                }
                if (c == '}' && last != '{') {
                    return false;
                }
            }
        }
        return bstack.isEmpty();
    }
}
