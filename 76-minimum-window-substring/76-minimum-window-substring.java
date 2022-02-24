class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        String res="";
        int[] stringCount = new int[128];
        int left = 0, count = 0, minLength = Integer.MAX_VALUE;
        for(char c: t.toCharArray())
            ++stringCount[c];
        for(int right = 0; right < s.length(); ++right) {
            if(--stringCount[s.charAt(right)] >= 0)
                ++count;
            while(count == t.length()) {
                if(minLength > right - left + 1){
                    minLength = right - left + 1;
                    res =s.substring(left, right + 1);
                }
                if(++stringCount[s.charAt(left)] > 0)
                    --count;
                ++left;
            }
        }
        return res;
    }
}