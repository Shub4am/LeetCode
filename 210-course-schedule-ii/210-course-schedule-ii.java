class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
            graph[pair[1]].add(pair[0]);
        }
        
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                toVisit.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : graph[from]) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    toVisit.offer(to);
                } else if (inDegree[to] < 0) {
                    return new int[0];
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }
}