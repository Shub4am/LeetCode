class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        for(int i = 2; i < num.length(); i++)
            if(num.charAt(i) == num.charAt(i - 1) && num.charAt(i - 1) == num.charAt(i - 2))
                if(num.substring(i - 2, i + 1).compareTo(res) > 0)
                    res = num.substring(i - 2, i + 1);
        return res;
    }
}