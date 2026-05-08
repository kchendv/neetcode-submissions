class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> x = new HashMap();
        int comp;
        for (int i = 0; i < nums.length; i++) {
            comp = target - nums[i];
            if (x.containsKey(comp)) {
                return new int[] {x.get(comp), i};
            }
            x.put(nums[i], i);
        }
        return new int[1];
    }
}
