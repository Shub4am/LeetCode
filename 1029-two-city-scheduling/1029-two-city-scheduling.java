class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (x, y)-> {
            return (x[0] - x[1]) - (y[0] - y[1]);
        });
        int minCost = 0;
        int len = costs.length / 2;
        for(int i = 0; i < len; ++i)
            minCost += costs[i][0];
        for(int i = len; i < costs.length; ++i)
            minCost += costs[i][1];
        return minCost;
    }
}