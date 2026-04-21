class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        if (piles.length == h) {
            return max;
        }
        
        int left = 1;
        int right = max;
        int res = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            int sum = 0;
            for (int pile : piles) {
                sum += Math.ceil((double) pile / mid);
            }

            if (sum <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }
}
