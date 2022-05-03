class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int max = Math.max(n, m) + 1;
        char[] result = new char[max + 1];
        int carry = 0;
        for (int i = n-1, j = m-1, k = max; ; i--, j--, k--) {
            int left = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int right = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = left + right + carry;
            result[k] = (char)((sum < 10) ? sum + '0' : sum - 10 + '0');
            carry = (sum < 10) ? 0 : 1;
            if (i < 0 && j < 0 && sum == 0) {
                return String.valueOf(result, k + 1, max - k);
            }
        }
    }
}