
class StockPrice {
    
    TreeMap<Integer, Integer> record = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> res = new TreeMap<>();

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> book = res.get(prevPrice);
            book.remove(timestamp);
            if (book.isEmpty()) {
                res.remove(prevPrice);
            }
        }
        res.putIfAbsent(price, new HashSet<>());
        res.get(price).add(timestamp);
        record.put(timestamp, price);
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return res.lastKey();
    }

    public int minimum() {
        return res.firstKey();
    }
}
/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */