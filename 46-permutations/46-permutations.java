class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = nums.length;
        
        for(int x: nums)
            arrayList.add(x);
        
        backtrack(n, arrayList, result, 0);
        return result;
    }
    
    public void backtrack(int n, ArrayList<Integer> arrayList, List<List<Integer>> result, int index){
        if(index == n) 
            result.add(new ArrayList<Integer>(arrayList));
        
        for(int i = index; i < n; i ++) {
            Collections.swap(arrayList, index, i);
            backtrack(n, arrayList, result, index + 1);
            Collections.swap(arrayList, index, i);
        }
    }
}