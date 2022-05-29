class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bitsets = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int wlen = words[i].length(), bitset = 0;
            for (int j = 0; j < wlen; j++)
                bitset |= 1 << (words[i].charAt(j) - 'a');
            for (int j = 0; j < i; j++)
                if ((bitsets[j] & bitset) == 0)
                    res = Math.max(res, wlen * words[j].length());
            bitsets[i] = bitset;
        }
        return res;
    }
}