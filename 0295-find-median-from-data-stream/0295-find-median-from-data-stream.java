class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if(high.size()>low.size()){
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if(low.size() != high.size()){
            return low.peek();
        }else{
            double ans = low.peek()+high.peek();
            return ans/2;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */