class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev1=0, prev2=0;
        for(int x: nums) {
            int take=x+prev2;
            int skip=prev1;
            int curr=Math.max(take, skip);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}