class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] i : people) 
            res.add(i[1], i);
        return res.toArray(new int[people.length][2]);
    }
}