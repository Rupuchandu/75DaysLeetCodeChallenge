class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        if(heights==null || heights.length==0) return res;
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];
        for(int i=0; i<rows; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, cols-1, Integer.MIN_VALUE);
        }
        for(int j=0; j<cols; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, rows-1, j, Integer.MIN_VALUE);
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prev) {
        if(row<0 || row>=heights.length || col<0 || col>=heights[0].length || visited[row][col] || heights[row][col]<prev) return;
        visited[row][col]=true;
        dfs(heights, visited, row+1, col, heights[row][col]);
        dfs(heights, visited, row-1, col, heights[row][col]);
        dfs(heights, visited, row, col+1, heights[row][col]);
        dfs(heights, visited, row, col-1, heights[row][col]);
    }
}