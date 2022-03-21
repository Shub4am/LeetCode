class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) 
            return false;
        int count = 0;
        int[] first = new int[26];
        int[] second = new int [26];
        for(int i = 0; i < s1.length(); i++) {
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i< 26; i++) {
            if(first[i] == second[i])
                count++;
        }
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            int right = s2.charAt(i + s1.length()) - 'a';
            int left = s2.charAt(i) - 'a';
            if(count == 26) 
                return true;
            second[right]++;
            if(second[right] == first[right]) 
                count++;
            else if(second[right] == first[right] + 1) 
                count --;
            second[left]--;
            
            if(second[left] == first[left]) 
                count++;
            else if(second[left] == first[left] - 1) 
                count--;
        }
        return count == 26;
    }
}