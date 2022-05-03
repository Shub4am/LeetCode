class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for(int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if(!seen.add(str))
                repeated.add(str);
        }
        return new ArrayList(repeated);
    }
}