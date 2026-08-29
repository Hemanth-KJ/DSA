class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       int rows=heights.length;
       int cols= heights[0].length;
          
          boolean[][] pacific = new boolean[rows][cols];
          boolean[][] Atlantic = new boolean[rows][cols];
       for(int col=0; col<cols; col++){
        dfs(heights, 0 , col, pacific);
       }
       for(int row=0; row<rows; row++){
        dfs(heights, row , 0, pacific);
       }
       for(int col=0; col<cols; col++){
        dfs(heights, rows-1 , col, Atlantic);
       }
       for(int row=0; row<rows; row++){
        dfs(heights, row , cols-1, Atlantic);
       }
         List<List<Integer>> result =new ArrayList<>();
         for(int row =0; row<rows; row++){
            for(int col=0; col<cols; col++){
                if(pacific[row][col] && Atlantic[row][col]){
                    result.add(Arrays.asList(row, col));
                }
            }
         }
     return result;  
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited){
        int rows=heights.length;
        int cols= heights[0].length;

       if(row<0 || row>=rows || col<0 || col>=cols){
        return;
       }
       if(visited[row][col]){
        return;
       }

       visited[row][col]=true;

       if(row-1 >= 0 && heights[row-1][col] >=heights[row][col]){
        dfs(heights,row-1, col, visited);
       }
         if(row+1 < rows && heights[row+1][col] >= heights[row][col]){
        dfs(heights,row+1, col, visited);
       }
         if(col+1 < cols && heights[row][col+1] >=heights[row][col]){
        dfs(heights,row, col+1, visited);
       }
         if(col-1 >= 0 && heights[row][col-1] >= heights[row][col]){
        dfs(heights,row, col-1, visited);
       }
    }
}