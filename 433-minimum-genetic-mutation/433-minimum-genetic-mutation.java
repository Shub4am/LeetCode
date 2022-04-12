class Solution {
    private int count = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(start);
        DFSHelper(start, end, bank, 0, visitedSet);
        return count == Integer.MAX_VALUE ? -1 : count;
    }
    private void DFSHelper(String start, String end, String[] bank, int moves, Set<String> visitedSet) {
        if (start.equals(end)) {
            count = Math.min(count, moves);
            return;
        }
        for (String validStr : bank) {
            if (visitedSet.contains(validStr)) continue;
            int diff = 0;
            for (int j = 0; j < 8; j++) {
                if (start.charAt(j) != validStr.charAt(j)) {
                    diff += 1;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                visitedSet.add(validStr);
                DFSHelper(validStr, end, bank, moves + 1, visitedSet);
                visitedSet.remove(validStr);
            }
        }
    }
}