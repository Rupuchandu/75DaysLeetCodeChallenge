class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        Arrays.sort(nums);
        while(l<r) {
            int mid=(l+r)/2;
            if(nums[mid]==target) {
                return mid;
            }
            if(nums[mid]<target) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }
}