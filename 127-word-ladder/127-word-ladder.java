class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) qe.add(endWord);
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len;
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb);
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe;
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }
}