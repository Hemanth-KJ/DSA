import java.util.*;

class Solution {

    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit
            map.put(
                fruits[right],
                map.getOrDefault(fruits[right], 0) + 1
            );

            // Too many fruit types
            while (map.size() > 2) {

                int fruit = fruits[left];

                map.put(
                    fruit,
                    map.get(fruit) - 1
                );

                // Remove fruit type completely
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }

            // Current window is valid
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}