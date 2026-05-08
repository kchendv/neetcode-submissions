class Solution {
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        return helper(0);
    }
    public List<List<Integer>> helper(int index) {
        if (index == nums.length) {
            return List.of(new ArrayList<Integer>());
        }
        // Take current, permute the rest
        List<List<Integer>> permuted = helper(index + 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> p: permuted) {
            for(int i = 0; i <= p.size(); i++) {
                List<Integer> pc = new ArrayList<>(p);
                pc.add(i, nums[index]);
                System.out.println(pc);
                ans.add(pc);
            }
        }
        return ans;
    }
}
