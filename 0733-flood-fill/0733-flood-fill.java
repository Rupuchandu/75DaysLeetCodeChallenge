class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org=image[sr][sc];
        if(org==color) return image;
        dfs(image, sr, sc, org, color);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int org, int color) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=org) {
            return;
        }
        image[sr][sc]=color;
        dfs(image, sr+1, sc, org, color);
        dfs(image, sr-1, sc, org, color);
        dfs(image, sr, sc+1, org, color);
        dfs(image, sr, sc-1, org, color);
    }
}