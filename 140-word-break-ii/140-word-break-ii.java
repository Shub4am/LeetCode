class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        helper("", s, wordDict);
        return res;
    }
    public void helper(String el, String s, List<String> wordDict){
        String key = "";
        if(s.length()==0){
            res.add(el);
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            key+=c;
            if(wordDict.contains(key)){
                String newel = el.equals("")?key:el+" "+key;
                helper(newel, s.substring(i+1,s.length()), wordDict);
            }
        }
        return;
    }
}