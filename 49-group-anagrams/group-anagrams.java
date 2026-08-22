import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {

                key.append('#');
                key.append(count[i]);
            }

            String keyString = key.toString();

            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<>());
            }

            map.get(keyString).add(s);
        }

        return new ArrayList<>(map.values());
    }
}