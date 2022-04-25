// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> res = new ArrayList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while(iterator.hasNext())
            res.add(iterator.next());
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return res.get(0);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int data = res.get(0);
        res.remove(0);
        return data;
	}
	
	@Override
	public boolean hasNext() {
	    return !res.isEmpty();
	}
}