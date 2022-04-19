class Solution {
    public List countSmaller(int[] nums) {
        List<Integer> sortedAndVisited = new ArrayList<>();
        int[] arr = new int[nums.length];
        for(int i = (nums.length-1); i >= 0; i--){
            arr[i] = binarySearchAndInsert(nums[i], 0, sortedAndVisited.size(), sortedAndVisited);
        }
        List<Integer> output = new ArrayList<>();
        for(int i=0; i < arr.length; i++) {
            output.add(arr[i]);
        }
        return output;
    }
    public int binarySearchAndInsert(int currentNo, int low, int high, List<Integer> sortedAndVisited){
        int mid = low + (high - low)/2;
        if(low >= high){
            sortedAndVisited.add(mid, currentNo);
            return mid;
        }
        if(currentNo <= sortedAndVisited.get(mid)){
            return binarySearchAndInsert(currentNo, low, mid, sortedAndVisited);
        }else{
            return binarySearchAndInsert(currentNo, mid + 1, high, sortedAndVisited);
        }
    }
}