class MedianFinder {

    PriorityQueue<Integer> smallMax;
    PriorityQueue<Integer> largeMin;

    public MedianFinder() {
        smallMax = new PriorityQueue<>(Comparator.reverseOrder());
        largeMin = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
        if (smallMax.peek() == null || num < smallMax.peek()) {
            smallMax.add(num);
        } else {
            largeMin.add(num);
        }

        if(Math.abs(smallMax.size() - largeMin.size()) > 1) {
            if (smallMax.size() > largeMin.size()) {
                largeMin.add(smallMax.poll());
            } else {
                smallMax.add(largeMin.poll());
            }
        }
    }
    
    public double findMedian() {

        if (smallMax.size() > largeMin.size()) {
            return smallMax.peek();
        } else if (largeMin.size() > smallMax.size()) {
            return largeMin.peek();
        } else {
            return (smallMax.peek() + largeMin.peek()) / 2.0;
        }
    }
}
