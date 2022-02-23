class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int water= 0;
        for(int i = 0; i < height.length; i++) {
            while((!s.isEmpty()) && (height[s.peek()] < height[i])) {
                int pop_height = height[s.peek()];
                s.pop();
                if(s.isEmpty())
                    break;
                int difference = i - s.peek() -1;
                int min_height = Math.min(height[s.peek()], height[i]) - pop_height;
                water += difference * min_height;
            }
            s.push(i);
        }
        return water;
        
    }
}