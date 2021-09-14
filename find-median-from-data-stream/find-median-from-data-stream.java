class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.isEmpty() && large.isEmpty()) {
            small.add(num);
            findMedian();
            return;
        }
        
        if(small.size() > large.size()) {
            if(num > small.peek()) {
                large.add(num);
            } else {
                large.add(small.poll());
                small.add(num);
            }
        } else {
            if(num < large.peek()){
                small.add(num);
            }else{
                small.add(large.poll());
                large.add(num);
            }
        }
        findMedian();  
    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return (small.peek() + large.peek())/2.0;
        }else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */