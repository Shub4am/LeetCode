class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;
        for(int[] i : boxTypes) {
            if(truckSize < i[0])
                return res + truckSize * i[1];
            res += i[0] * i[1];
            truckSize -= i[0];
        }    
        return res;
    }
}