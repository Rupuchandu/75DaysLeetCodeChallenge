class Solution {
    public int majorityElement(int[] nums) {
        int candid=0;
        int count=0;
        for(int x: nums) {
            if(count==0) candid=x;
            if(x==candid) {
                count++;
            } else {
                count--;
            }
        }
        return candid;
    }
}