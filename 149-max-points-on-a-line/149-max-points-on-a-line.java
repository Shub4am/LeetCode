class Solution{
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        int n = points.length;
        if (n <= 2) return n;
        Map<Pair<Integer,Integer>, Integer> map = new HashMap();
        int result = 0;
        for (int i = 0; i < n; i++){ 
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i+1; j < n; j++){
                int dx = points[j][0]-points[i][0];
                int dy = points[j][1]-points[i][1];
                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(dx, dy);
                if (gcd != 0) {
                    dx /= gcd;
                    dy /= gcd;
                }
                Pair<Integer,Integer> line = new Pair(dx, dy);
                map.put(line, map.containsKey(line) ? map.get(line) + 1 : 1);
                max = Math.max(max, map.get(line));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }
    private int generateGCD(int a, int b){
        return (b == 0) ? a : generateGCD(b, a % b);
    }
}