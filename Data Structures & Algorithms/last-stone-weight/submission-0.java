class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int stoneY = maxHeap.poll();
            int stoneX = maxHeap.poll();
            if (stoneX < stoneY) {
                maxHeap.add(stoneY - stoneX);
            }
        }

        if (maxHeap.size() == 1) {
            return maxHeap.peek();
        }

        return 0;
    }
}
