class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> aList = new ArrayList<>(n);
        for(int i : nums){
            if(aList.size() == 0 ||  i > aList.get(aList.size() - 1)) 
                aList.add(i);
            else{
                int search = Collections.binarySearch(aList, i);
                aList.set((search < 0) ? -search - 1 : search, i);
            }
        }
        return aList.size();
    }
}
