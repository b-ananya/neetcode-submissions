class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxf = 0;
        for (int c : count) {
            if (c > maxf) {
                maxf = c;
            }
        }

        int maxCount = 0;
        for (int i : count) {
            if (i == maxf) {
                maxCount++;
            }
        }

        int time = (maxf - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, time);

    }
}
