class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        window = []
        str1 = sorted(s1)

        for right in range(len(s2)):
            if len(window) < len(s1):
                window.append(s2[right])
            else:
                word = sorted(window)
                if word == str1:
                    return True
                window.pop(0)
                window.append(s2[right])
        
        if sorted(window) == str1:
            return True
        return False

                


        