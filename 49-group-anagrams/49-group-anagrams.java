class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        
        Map<String, List> results = new HashMap<>();
        int[] count = new int[26];
        
        
        for(String s: strs) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) 
                count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            
            String key = sb.toString();
            if(!results.containsKey(key))
                results.put(key, new ArrayList());
            results.get(key).add(s);
        }
        return new ArrayList(results.values());
    }
}