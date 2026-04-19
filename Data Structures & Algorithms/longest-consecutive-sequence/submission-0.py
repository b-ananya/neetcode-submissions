class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest = 0
        for num in nums:
            i = num
            length = 0
            while i in num_set:
                i += 1
                length += 1
            if length > longest:
                longest = length
        return longest


        