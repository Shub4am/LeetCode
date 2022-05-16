class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a,b)->a[0]-b[0]);
        int max = 0, j = 0, val = 0;
        for(int i = 0; i < tiles.length; i++) {
            int fin = tiles[i][0] + carpetLen;
            while (j < tiles.length && fin > tiles[j][1] ) {
                val += (tiles[j][1] - tiles[j][0] + 1);
                j++;
            }
            if (j < tiles.length)
                max = Math.max(max, val + Math.max(fin - tiles[j][0], 0));
            max = Math.max(max, val);
            val -= (tiles[i][1] - tiles[i][0] + 1);
        }
        return max;
    }
}