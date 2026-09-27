import java.util.*;

class Solution {

    public int findMaxValueOfEquation(int[][] points, int k) {
     int n = points.length;
     int answer = Integer.MIN_VALUE;

     Deque<Integer> deque = new ArrayDeque<>();

     for(int j=0; j<n; j++){
        while(!deque.isEmpty() && points[j][0] - points[deque.peekFirst()][0] > k){
            deque.pollFirst();
        }

        if(!deque.isEmpty()){
            int i = deque.peekFirst();
            int value = points[i][1] + points[j][1] + points[j][0]-points[i][0];

            answer= Math.max(answer, value);
        }

        while(!deque.isEmpty() && points[deque.peekLast()][1] -points[deque.peekLast()][0] <= points[j][1]-points[j][0]){
            deque.pollLast();
        }

        deque.offerLast(j);
     }
     return answer;
    }
}