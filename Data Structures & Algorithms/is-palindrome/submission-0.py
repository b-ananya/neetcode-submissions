class Solution:
    def isPalindrome(self, s: str) -> bool:
        stripped = "".join(char for char in s if char.isalnum()).lower()
        i = 0
        while i < len(stripped)//2:
            if stripped[i] != stripped[len(stripped) - 1 - i]:
                return False
            i+=1
        return True

        