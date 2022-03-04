/* This problem is a variant of Pascal's Triangle in which each 
* item in the Triangle is the sum of its "left parent" and "right parent". 
* However instead of the total sum, we need to calculate the total overflow sum.
*/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        List<Double> aList = new ArrayList<>();
        aList.add(Double.valueOf(poured));
        while(query_row > 0){
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max((aList.get(0) - 1) / 2,0));
            for(int i = 1; i < aList.size(); i++)
                temp.add(Math.max((aList.get(i - 1) - 1) / 2,0) + Math.max((aList.get(i) - 1) / 2,0));
            temp.add(temp.get(0));
            aList = new ArrayList<>(temp);
            query_row--;
        }
        return Math.min(1, aList.get(query_glass));
    }
}