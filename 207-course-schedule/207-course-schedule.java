public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] canFinish = new boolean[numCourses]; 
        boolean[] waitingList = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishThisCourse(i,prerequisites,waitingList,canFinish)) { 
                return false; 
            }
        }
        return true;
    }
    
    public boolean canFinishThisCourse(int course, int[][] prerequisites, boolean[] waitingList, boolean[] canFinish) {
        if (canFinish[course]) { 
            return true; 
        }
        if (waitingList[course]) {
            return false; 
        }
        
        waitingList[course] = true;
        for (int[] pair : prerequisites) {
            if (pair[0] == course) {
                if (!canFinishThisCourse(pair[1],prerequisites,waitingList,canFinish)) {
                    return false; 
                }
            }
        }
        waitingList[course] = false;
        canFinish[course] = true;
        return true;
    }
}