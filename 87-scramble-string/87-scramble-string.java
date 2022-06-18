class Solution {
    static HashMap<String,Boolean> map ;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        if(s1.length() !=  s2.length())  
            return false;
        if(s1.length() == 0) return true;
        return helper(s1,s2);
    }
    private static boolean helper(String A ,String B){
        if(A.compareTo(B) == 0) return true;
        if( A.length() <= 1) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb.append("_");
        sb.append(B);
        String k = sb.toString();
        if(map.containsKey(k)) return map.get(k);
        int N  = A.length();
        boolean flag = false;
        for(int i = 1; i< N; i++){
            boolean condition1 =  (helper(A.substring(0,i),B.substring(N-i,N))) && (helper(A.substring(i,N),B.substring(0,N-i)));
           
            boolean condition2 = false;
            if(condition1 == false){
                condition2 = (helper(A.substring(0,i),B.substring(0,i))) && (helper(A.substring(i,N),B.substring(i,N)));  
            }
            if( condition1 || condition2 ){
                flag = true;
                break;
            }
        }
        map.put(k,flag);
        return flag;
    }
}