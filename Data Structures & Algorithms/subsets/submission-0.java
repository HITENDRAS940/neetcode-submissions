class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, nums, curr, res);

        return res;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> curr,
                           List<List<Integer>> res) {

        // Base Case
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Include nums[index]
        curr.add(nums[index]);
        backtrack(index + 1, nums, curr, res);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Exclude nums[index]
        backtrack(index + 1, nums, curr, res);
    }
}