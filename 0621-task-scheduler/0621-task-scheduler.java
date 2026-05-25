class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task: tasks) {
            freq[task-'A']++;
        }
        int max=0;
        for(int x: freq) {
            max=Math.max(max, x);
        }
        int maxCo=0;
        for(int x: freq) {
            if(x==max) {
                maxCo++;
            }
        }
        int inter=(max-1)*(n+1)+maxCo;
        return Math.max(tasks.length, inter);
    }
}