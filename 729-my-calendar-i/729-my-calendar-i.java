class MyCalendar {
    TreeMap<Integer, Integer> books = new TreeMap<>();
    public boolean book(int start, int end) {
        java.util.Map.Entry<Integer, Integer> floor = books.floorEntry(start), ceiling = books.ceilingEntry(start);
        if (floor != null && start < floor.getValue()) return false;
        if (ceiling != null && ceiling.getKey() < end) return false;
        books.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */