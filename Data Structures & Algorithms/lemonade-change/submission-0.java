class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                five--;
                ten++;
            // has to be $20 now
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }

            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}