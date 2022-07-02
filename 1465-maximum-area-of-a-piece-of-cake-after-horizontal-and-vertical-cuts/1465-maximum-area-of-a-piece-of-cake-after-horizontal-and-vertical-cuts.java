class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHorizontal = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]),
            maxVertical = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++)
            maxHorizontal = Math.max(maxHorizontal, horizontalCuts[i] - horizontalCuts[i - 1]);
        for (int i = 1; i < verticalCuts.length; i++)
            maxVertical = Math.max(maxVertical, verticalCuts[i] - verticalCuts[i - 1]);
        return (int)((long)maxHorizontal * maxVertical % 1000000007);
    }
}