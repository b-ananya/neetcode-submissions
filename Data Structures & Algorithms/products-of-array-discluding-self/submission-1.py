class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        solution = []
        product = 1
        zero_cnt = 0
        for num in nums:
            if num == 0:
                zero_cnt += 1
            else:
                product *= num
        
        if zero_cnt > 1:
            return [0] * len(nums)
        
        for num in nums:
            if zero_cnt > 0:
                if num == 0:
                    solution.append(product)
                else:
                    solution.append(0)
            else:
                solution.append(product//num)
        return solution
        