class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        max_rate = max(piles)
        min_rate = 1

        while min_rate <= max_rate:
            mid_rate = (min_rate + max_rate) // 2

            hours = 0
            for i in range(len(piles)):
                hours += math.ceil(float(piles[i]) / mid_rate)
            
            if hours > h:
                min_rate = mid_rate + 1
            elif hours <= h:
                max_rate = mid_rate - 1
        
        return min_rate



        

        