
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] countTops = new int[7], countBottoms = new int[7];
        for (int i = 0; i < tops.length; ++i) {
            s.retainAll(new HashSet<>(Arrays.asList(tops[i], bottoms[i])));
            countTops[tops[i]]++;
            countBottoms[bottoms[i]]++;
        }
        for (int i : s)
            return tops.length - Math.max(countTops[i], countBottoms[i]);
        return -1;
    }
}