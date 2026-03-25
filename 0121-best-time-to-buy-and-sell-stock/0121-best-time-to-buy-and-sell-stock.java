class Solution {
    public int maxProfit(int[] prices) {
        int minProfit=prices[0];
        int maxProfit=0;
        int profit=0;
        for(int x: prices) {
            if(x<minProfit) {
                minProfit=x;
            }
            profit=x-minProfit;
            if(profit>maxProfit) {
                maxProfit=profit;
            }
        }
        return maxProfit;
    }
}