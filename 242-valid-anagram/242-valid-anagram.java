public class Solution {
  public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[26];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if(++map[cs[i]-'a'] == 1) count ++;
            if(--map[ct[i]-'a'] == 0) count --;
        }
        return count == 0;
  }
}