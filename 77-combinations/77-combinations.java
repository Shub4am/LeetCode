class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(k>n) return list;
        addToList(list, new ArrayList<Integer>(), k, n, 1);
        return list;
    }
    public void addToList(List<List<Integer>> list, List<Integer> temp, int k, int n, int m){
        if(k==0){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=m;i<=n+1-k;i++){
            temp.add(i);
            addToList(list,temp,k-1,n,i+1);
            temp.remove(temp.size()-1);
        }
    }
}