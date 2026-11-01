
import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
       int m = heightMap.length;
       int n = heightMap[0].length; 

       boolean[][] visited = new boolean[m][n];

       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->Integer.compare(a[0], b[0]));

       for(int row = 0; row<m; row++){
        pq.offer(new int[]{heightMap[row][0], row, 0});
        pq.offer(new int[]{heightMap[row][n-1],row, n-1});
        visited[row][0]=true;
        visited[row][n-1]=true;
       }

       for(int col = 0; col<n; col++){
        pq.offer(new int[]{heightMap[0][col], 0, col});
        pq.offer(new int[]{heightMap[m-1][col],m-1, col});
        visited[0][col]=true;
        visited[m-1][col]=true;
       }

       int[][] directions= {{0,1},{0,-1},{1,0},{-1,0}};

       int water=0;

       while(!pq.isEmpty()){
        int[] cell = pq.poll();
          int height=cell[0];
          int row=cell[1];
          int col=cell[2];

           for(int[] dir : directions){

            int nr= row+ dir[0];
            int nc= col+ dir[1];

            if(nr < 0 || nc < 0 || nr >= m ||nc >= n ||  visited[nr][nc] ){
                continue;
            }

            visited[nr][nc]=true;

            water += Math.max(0, height-heightMap[nr][nc]);

            int effectiveheight =Math.max(height, heightMap[nr][nc]);

            pq.offer(new int[]{effectiveheight, nr, nc});
           }
       }
       return water;
    }
}
