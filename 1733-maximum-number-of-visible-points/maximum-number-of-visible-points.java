import java.util.*;

class Solution {

    public int visiblePoints(
        List<List<Integer>> points,
        int angle,
        List<Integer> location
    ) {

        List<Double> angles = new ArrayList<>();

        int same = 0;

        int x = location.get(0);
        int y = location.get(1);

        for (List<Integer> point : points) {

            int dx = point.get(0) - x;
            int dy = point.get(1) - y;

            if (dx == 0 && dy == 0) {
                same++;
                continue;
            }

            double degree = Math.toDegrees(
                Math.atan2(dy, dx)
            );

            angles.add(degree);
        }

        Collections.sort(angles);

        int n = angles.size();

        // Duplicate angles to handle circular rotation
        for (int i = 0; i < n; i++) {
            angles.add(angles.get(i) + 360.0);
        }

        int left = 0;
        int maxVisible = 0;

        // Sliding window
        for (int right = 0; right < angles.size(); right++) {

            while (angles.get(right) - angles.get(left)
                    > angle + 1e-9) {

                left++;
            }

            maxVisible = Math.max(
                maxVisible,
                Math.min(n, right - left + 1)
            );
        }

        return maxVisible + same;
    }
}