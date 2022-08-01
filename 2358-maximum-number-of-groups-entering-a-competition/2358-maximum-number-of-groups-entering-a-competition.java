class Solution {
    public int maximumGroups(int[] grades) {
        return (int)(Math.sqrt(grades.length * 2 + 0.25) - 0.5);
    }
}