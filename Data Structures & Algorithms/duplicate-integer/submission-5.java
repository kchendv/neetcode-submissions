class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet hasSeen = new HashSet();
        for(int num: nums) {
            if(hasSeen.contains(num)) {
                return true;
            } else {
                hasSeen.add(num);
            }
        }
        return false;
    }
}