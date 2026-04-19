class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();

        combinationSum(nums, target, 0, res, combo);
        
        return res;
    }

    private void combinationSum(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> combo) {
        if (target <= 0 || i >= nums.length) {
            if (target == 0) {
                res.add(new ArrayList(combo));
            }
            return;
        }
  
        int num = nums[i];
        combo.add(num);
        combinationSum(nums, target - num, i, res, combo);
        combo.remove(combo.size() - 1);
        combinationSum(nums, target, i + 1, res, combo);

    }



}
