class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""
        
        left = 0
        need, window = {}, {}
        string = ""
        string_len = float("infinity")

        for char in t:
            need[char] = need.get(char, 0) + 1
        
        total_needed = len(need)
        have = 0

        for right in range(len(s)):

            char = s[right]
            window[char] = window.get(char, 0) + 1

            if char in need and window[char] == need[char]:
                have += 1
            
            while have == total_needed:
                if (right - left + 1) < string_len:
                    string = s[left:right+1]
                    string_len = right - left + 1
                
                window[s[left]] -= 1
                if s[left] in need and window[s[left]] < need[s[left]]:
                    have -= 1
                
                left += 1
            
        return string if string_len != float("infinity") else ""