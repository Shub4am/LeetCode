class Solution {
    public long sumScores(String s) {
	    char[] ch = s.toCharArray();
	    int n = ch.length, x = 0, y = 0;
	    int[] z = new int[n];
	    long res = n;
	    for(int i = 1; i < n; i++) {
		    z[i] = Math.max(0, Math.min(z[i - x], y - i + 1));
            
		    while(i + z[i] < n && ch[z[i]] == ch[i + z[i]]){
			    x = i; 
                y = i + z[i]; 
                z[i]++;
            }
            res += z[i];
        }
        return res;
    }
}