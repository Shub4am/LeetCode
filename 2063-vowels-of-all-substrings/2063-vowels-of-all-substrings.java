class Solution {
    public long countVowels(String word) {
        long res = 0, n = word.length();
        for (int i = 0; i < n; ++i)
            if ("aeiou".indexOf(word.charAt(i)) >= 0)
                res += (i + 1) * (n - i);
        return res;
    }
}