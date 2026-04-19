class Solution:

    def encode(self, strs: List[str]) -> str:
        final = ""
        for s in strs:
            final += str(len(s)) + "#" + s
        return final            

    def decode(self, s: str) -> List[str]:
        words = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1
            num = int(s[i:j])
            words.append(s[j+1:j+1+num])
            i = j + num + 1
        return words


