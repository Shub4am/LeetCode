class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String curr, int open, int close, int max) {
        if(curr.length() == max * 2) {
            list.add(curr.toString());
            return;
        }
        if(open < max)
            backtrack(list, curr + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, curr + ")", open, close + 1, max);
    }
}