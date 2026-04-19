class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> soFar = new ArrayList<>();
        subsets(nums, 0, subsets, soFar);
        return subsets;
        
    }

    private void subsets(int[] nums, int index, List<List<Integer>> subsets, List<Integer> soFar) {
        if (index >= nums.length) {
            subsets.add(new ArrayList<>(soFar));
            return;
        }

        soFar.add(nums[index]);
        subsets(nums, index + 1, subsets, soFar);
        soFar.remove(soFar.size() - 1);
        subsets(nums, index + 1, subsets, soFar);
    }
}
