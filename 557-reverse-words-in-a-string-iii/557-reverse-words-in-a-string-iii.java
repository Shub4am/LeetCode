class Solution {
    public String reverseWords(String s) {
        final StringBuilder res = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                res.append(word.reverse());
                res.append(" ");
                word.setLength(0);
            }
        }
        res.append(word.reverse());
        return res.toString();
    }
}