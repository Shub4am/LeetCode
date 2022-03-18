class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26]; 
        boolean[] visited = new boolean[26]; 
        char[] ch = s.toCharArray();
        for(char c : ch){  
            res[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index;
        for(char c : ch){ 
            index = c - 'a';
            res[index]--;
            if(visited[index])
                continue;
            while( (sb.length() > 0) && c < sb.charAt(sb.length()-1) && res[sb.charAt(sb.length()-1)-'a']!=0){ 
                visited[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(c); 
            visited[index] = true;
        }
        return sb.toString();
    
    }
}