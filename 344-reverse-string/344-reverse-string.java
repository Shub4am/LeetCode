class Solution {
    public void reverseString(char[] s) {
        int pointer1 = 0;
        int pointer2 = s.length - 1;
        while(pointer1 <= pointer2){
            char temp = s[pointer1];
            s[pointer1] = s[pointer2];
            s[pointer2] = temp;
            pointer1 += 1;
            pointer2 -= 1;
        }
    }
}