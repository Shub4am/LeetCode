class Solution {
    public String countAndSay(int n) {
        String[] str = new String[]{"1"};
        if(n == 1) return str[0];
        for(int i = 2; i <= n; i++) {
            str[0] = helper(str[0]);
        }
        return str[0];
    }
    public String helper(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int count = 1;
            while(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}