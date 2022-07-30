class Solution {
   public List<String> wordSubsets(String[] A, String[] B) {
        int[] count = new int[26], temp;
        int i;
        for (String sb : B) {
            temp = counter(sb);
            for (i = 0; i < 26; ++i)
                count[i] = Math.max(count[i], temp[i]);
        }
        List<String> res = new ArrayList<>();
        for (String sa : A) {
            temp = counter(sa);
            for (i = 0; i < 26; ++i)
                if (temp[i] < count[i])
                    break;
            if (i == 26) res.add(sa);
        }
        return res;
    }

    int[] counter(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) count[c - 'a']++;
        return count;
    }
}
