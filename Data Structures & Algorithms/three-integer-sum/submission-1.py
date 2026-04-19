class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        triples = []
        nums.sort()
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            target = nums[i] * (0-1)
            left = i+1
            right = len(nums) - 1

            while left < right:
                if nums[left] + nums[right] < target:
                    left += 1
                elif nums[left] + nums[right] > target:
                    right -= 1
                else:
                    triples.append([nums[i], nums[left], nums[right]])
                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
        
        return triples


        
        