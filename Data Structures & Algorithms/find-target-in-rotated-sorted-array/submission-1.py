class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid
            
            if nums[mid] >= nums[left]:
                if nums[mid] > target and target >= nums[left]:
                    right = mid - 1
                elif nums[mid] > target and target <= nums[left]:
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
            else:
                if nums[mid] < target and nums[right] >= target:
                    left = mid + 1
                elif nums[mid] < target and nums[right] <= target:
                    right = mid - 1
                elif nums[mid] > target:
                    right = mid - 1
        return -1



        