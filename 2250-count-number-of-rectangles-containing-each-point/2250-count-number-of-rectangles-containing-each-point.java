class Solution {
    int binsear(ArrayList<Integer> arr, int x){
        int l = 0, r = arr.size() - 1;
        int anstillnow = arr.size();
        while(l <= r){
            int m = l + (r - l) / 2;
            if(arr.get(m) >= x){
                anstillnow = m;
                r = m - 1;
            }
            else{
                l=m+1;
            } 
        }
        return anstillnow;
    }
    public int[] countRectangles(int[][] rect, int[][] points) {
        HashMap<Integer, ArrayList<Integer>> htl = new HashMap<>();
        
        for(int i = 0; i < rect.length; i++){       
            if(htl.containsKey(rect[i][1])) htl.get(rect[i][1]).add(rect[i][0]);
            else 
            {
                htl.put(rect[i][1],new ArrayList<>());
                htl.get(rect[i][1]).add(rect[i][0]);
            }
        }
        for(int a:htl.keySet()){
            Collections.sort(htl.get(a));        
        }
        int[] res = new int[points.length];
        for(int i = 0;i < points.length; i++){
            int x = points[i][0], y = points[i][1];
            int ct = 0;
            for(int j = y; j <= 100; j++){
                if(htl.containsKey(j)){
                    ct += htl.get(j).size()- binsear(htl.get(j), x);
                }
            }
            
            res[i] = ct;
            
        }
        
        return res;        
    }
}