class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // each entry in the heap is [frquency, number]
        // min heap: sorts by smallest frequency first
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // add {frequency, number} to the heap
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            // i it goes larger than k, remove the smallest frequency (top of heap)
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // storing number value of the top k frequent elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }

        return res;
    }
}
