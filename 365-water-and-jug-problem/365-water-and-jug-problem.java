class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        if( jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity )
            return true;
        return targetCapacity % GCD(jug1Capacity, jug2Capacity) == 0;
    }
    public int GCD(int x, int y){
        while(y != 0 ){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}