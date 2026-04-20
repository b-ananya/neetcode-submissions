class Solution {
    public int maxAscendingSum(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int cur = nums[0];
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > nums[right - 1]) {
                cur += nums[right];
            } else {
                max = Math.max(max, cur);
                cur = nums[right];
            }
        }

        return Math.max(max, cur);
        
    }
}