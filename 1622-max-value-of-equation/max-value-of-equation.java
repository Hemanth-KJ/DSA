import java.util.*;

class Solution {

    public int findMaxValueOfEquation(int[][] points, int k) {

        Deque<Integer> deque = new ArrayDeque<>();

        int answer = Integer.MIN_VALUE;

        for (int j = 0; j < points.length; j++) {

            // 1. Remove points outside the range
            while (!deque.isEmpty()
                    && points[j][0] - points[deque.peekFirst()][0] > k) {

                deque.pollFirst();
            }

            // 2. Calculate answer using the best previous point
            if (!deque.isEmpty()) {

                int i = deque.peekFirst();

                int value =
                        points[i][1]
                        - points[i][0]
                        + points[j][1]
                        + points[j][0];

                answer = Math.max(answer, value);
            }

            // 3. Remove smaller (y - x) values
            while (!deque.isEmpty()
                    && points[deque.peekLast()][1]
                       - points[deque.peekLast()][0]
                       <= points[j][1]
                       - points[j][0]) {

                deque.pollLast();
            }

            // 4. Add current point
            deque.offerLast(j);
        }

        return answer;
    }
}