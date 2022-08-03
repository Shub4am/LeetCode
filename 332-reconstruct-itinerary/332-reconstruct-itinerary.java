class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> hashMap = new HashMap<String,PriorityQueue<String>>();
        for(List<String> s :tickets){
            String s1 = s.get(0);
            String s2 = s.get(1);
            hashMap.putIfAbsent(s1, new PriorityQueue<>());
            hashMap.get(s1).add(s2);
        }
        List<String> res = new ArrayList<>();
        helper(hashMap, "JFK", res);
        return res;
    }
    public void helper(HashMap<String, PriorityQueue<String>> hashMap, String s, List<String> res){
        while(hashMap.get(s) != null && !hashMap.get(s).isEmpty()) {
            String curr = hashMap.get(s).poll();
            helper(hashMap, curr, res);
        }
        res.add(0, s);
    }
}