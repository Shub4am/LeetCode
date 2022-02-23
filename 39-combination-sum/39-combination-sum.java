class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> combinations = new LinkedList<>();
        this.backtrack(target, combinations, 0, candidates, res);
        return res;
        
    }
    
    protected void backtrack(int remainder, LinkedList<Integer> combinations, int start, int[] candidates, List<List<Integer>> res) {
        if( remainder == 0) {
            res.add(new ArrayList<Integer>(combinations));
            return;
        }else if(remainder < 0) {
            return;
        }
        
        for(int i = start; i < candidates.length; ++i) {
            combinations.add(candidates[i]);
            this.backtrack(remainder - candidates[i], combinations, i, candidates, res);
            combinations.removeLast();
        }
    }
}