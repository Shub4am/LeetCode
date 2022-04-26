class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        Set<String> words = new HashSet(wordList);
        Set<String> start = new HashSet();
        start.add(beginWord);
        boolean found = false;
        Map<String, List<List<String>>> map = new HashMap();
        List<String> init = new ArrayList();
        init.add(beginWord);
        map.put(beginWord, new ArrayList());
        map.get(beginWord).add(init);
        while(!words.isEmpty() && !found && !start.isEmpty()){
            words.removeAll(start);
            Set<String> newStart = new HashSet();
            for(String s: start){
                char[] chs = s.toCharArray();
                List<List<String>> endPath  = map.get(s);
                for(int i = 0; i < chs.length; i++){
                    for(char ch ='a';ch <='z';ch++){
                        if(chs[i]==ch) continue;
                        char tmp = chs[i];
                        chs[i] = ch;
                        String word = new String(chs);
                        if(words.contains(word)){
                            newStart.add(word);
                            for(List<String> path:endPath){
                                List<String> nextPath = new ArrayList(path);
                                nextPath.add(word);
                                map.putIfAbsent(word, new ArrayList());
                                map.get(word).add(nextPath);
                                if(word.equals(endWord)){
                                    found = true;
                                    res.add(nextPath);
                                }
                            }

                        }
                        chs[i] = tmp;
                    }
                }
                map.remove(s);
            }
            start.clear();
            start.addAll(newStart);
            
        }
        
        return res;
    }
    
}