class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int[] res = new int [n];
        
        for(int i = n -1; i >= 0; i--) {
            int currTemp = temperatures[i];
            if(currTemp >= hottest){
                hottest = currTemp;
                continue;
            }
            int days = 1;
            while(temperatures[i + days] <= currTemp){
                days+= res[i + days];
            }
            res[i] = days;
        }
        return res;
    }
}