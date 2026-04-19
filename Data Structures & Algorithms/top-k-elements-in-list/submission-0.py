class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        top = []
        my_dict = defaultdict(int)
        for num in nums:
            my_dict[num] += 1
        
        for i in range(k):
            max_val_key = max(my_dict, key=my_dict.get)
            top.append(max_val_key)
            my_dict.pop(max_val_key)
        
        return top

        