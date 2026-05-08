class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> x = new HashMap<>();
        for (String s: strs) {
            List<Integer> counts = new ArrayList();
            for (int i =0; i<26; i++){
                counts.add(0);
            }
            for(char c: s.toCharArray()) {

                counts.set(c - 'a', counts.get(c-'a')+1);
            }
            System.out.println(s.toString() + " " + counts.toString());
            List<String> ts = x.get(counts);
            if (ts == null) {
                ts = new ArrayList();
            }
            ts.add(s);
            x.put(counts, ts);
        
        }
        List<List<String>> f = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String>> entry : x.entrySet()) {
            f.add(entry.getValue());
        }
        return f;
    }
}
