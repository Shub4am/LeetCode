class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int j: pushed){
            stack.push(j);
            while(!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}