class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxArea=0;
        while(l<r) {
            int width=r-l;
            int h=Math.min(height[l], height[r]);
            int area=width*h;
            maxArea=Math.max(area, maxArea);
            if(height[l]<height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}