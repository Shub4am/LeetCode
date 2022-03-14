class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq =  new LinkedList<>();
        String[] each = path.split("/");
        StringBuilder res = new StringBuilder();
        for(String i : each){
            if(!i.isEmpty() && i.equals(".."))
                dq.poll();
            else if(!i.equals("") && !i.equals(".") && !i.equals(".."))
                dq.push(i);
        }
        if(dq.isEmpty())
            return "/";
        while(!dq.isEmpty()){
            res.append("/").append(dq.pollLast());
        }
        return res.toString();
    }
}