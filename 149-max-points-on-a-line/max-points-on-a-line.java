import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
      int n= points.length;
      if(n <= 2){
        return n;
      }
      int answer = 2;   
     
     for(int i=0; i<n; i++){
        Map<String, Integer> map =new HashMap<>();
        int duplicate=0;
        int currentmax=0;
        for(int j=i+1; j<n; j++){
            int dy=points[j][1]-points[i][1];
            int dx=points[j][0]-points[i][0];

            if(dy == 0 && dx ==0){
                duplicate++;
                continue;
            }

            int gcd = gcd(Math.abs(dx), Math.abs(dy));

            dx /= gcd;
            dy /= gcd;

            if(dx < 0){
                dx= -dx;
                dy= -dy;
            }

            if(dx == 0){
                dy = 1;
            }
            if(dy == 0){
                dx = 1;
            }

            String slop = dy + "/" + dx;

            int count = map.getOrDefault(slop, 0)+1;
            map.put(slop, count);
            currentmax= Math.max(currentmax, count);
        } 
          answer = Math.max(answer, currentmax+duplicate+1);
        }
     return answer;
    }
    private int gcd(int a, int b){
       while(b != 0){
            int temp = a%b;
            a= b;
            b=temp;
        }
        return a;
    }
}