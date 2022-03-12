class MedianFinder {
    private Queue<Integer> small = new PriorityQueue(1, new Comparator<Integer>() {
		   public int compare(Integer o1, Integer o2) {
			   return o2 - o1; 
		   }
    });
	   
   private Queue<Integer> large = new PriorityQueue();
    
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }
    
    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

