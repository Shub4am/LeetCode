class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0)
            return null;
        int[] lastIndices = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastIndices[s.charAt(i) - 'a'] = i;
        
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            if(i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}