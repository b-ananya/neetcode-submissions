class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dictionary = {}
        for string in strs:
            sorted_str = "".join(sorted(string))
            if dictionary.get(sorted_str) is not None:
                dictionary[sorted_str].append(string)
            else:
                dictionary[sorted_str] = [string]
        return list(dictionary.values())
        