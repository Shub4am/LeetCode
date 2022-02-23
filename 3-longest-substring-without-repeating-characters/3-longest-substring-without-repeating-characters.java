class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int length = 0, left = 0, right = 0;
        int str = s.length();
        while(right < str) {
            if(hashmap.containsKey(s.charAt(right)))
                left = Math.max(hashmap.get(s.charAt(right))+1, left);
            hashmap.put(s.charAt(right), right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}