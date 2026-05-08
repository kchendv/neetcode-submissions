class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> cs = new HashMap();
        for (char c: s.toCharArray()) {
            cs.put(c, cs.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            cs.put(c, cs.getOrDefault(c, 0) - 1);
        }
        for(int i: cs.values()) {
            System.out.println(i);
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
