class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if(digits.length() == 0) return list;
        list.add("");
        
        String[] charMap = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while(list.peek().length() == i) {
                String str = list.remove();
                for (char c : charMap[x].toCharArray()) {
                    list.add(str + c);
                }
            }
        }
        return list;
    }
}