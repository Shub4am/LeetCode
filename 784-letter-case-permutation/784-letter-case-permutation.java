class Solution {
    public List<String> letterCasePermutation(String S) {
        LinkedList<String> r = new LinkedList<>();
        r.add(S);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c))
                for (int size = r.size(); size > 0; size--) {
                    String s = r.poll(), left = s.substring(0, i), right = s.substring(i + 1);
                    r.add(left + Character.toLowerCase(c) + right);
                    r.add(left + Character.toUpperCase(c) + right);
                }
        }
        return r;
    }
}