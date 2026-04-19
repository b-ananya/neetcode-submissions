class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_length = 0
        left = 0
        window = set()

        for right in range(len(s)):
            while s[right] in window:
                window.remove(s[left])
                left += 1
            window.add(s[right])
            max_length = max(max_length, right - left + 1)
        
        return max_length


