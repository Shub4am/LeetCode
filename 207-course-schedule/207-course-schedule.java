class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] recStack = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (isCyclic(i, visited, recStack, adjList)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCyclic(int v, boolean [] visited, boolean [] recStack, List<List<Integer>> adjList) {
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }
        recStack[v] = true;
        visited[v] = true;
        List<Integer> courses = adjList.get(v);
        for (Integer course: courses) {
            if (isCyclic(course, visited, recStack, adjList)) {
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }
}