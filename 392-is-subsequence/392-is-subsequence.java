class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) 
            return true;
        int pointerS = 0, pointerT = 0;
        
        while(pointerT < t.length()) {
            if(t.charAt(pointerT) == s.charAt(pointerS))
                pointerS++;
            pointerT++;
            if(pointerS == s.length())
                return true;
        }
        return false;
    }
}