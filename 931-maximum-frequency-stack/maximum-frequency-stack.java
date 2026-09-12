import java.util.*;

class FreqStack {

    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;

    private int maxFreq;

    public FreqStack() {

        freq = new HashMap<>();
        group = new HashMap<>();

        maxFreq = 0;
    }

    public void push(int val) {

        // Increase frequency
        int newFreq = freq.getOrDefault(val, 0) + 1;

        freq.put(val, newFreq);

        // Create stack for this frequency if needed
        if (!group.containsKey(newFreq)) {
            group.put(newFreq, new Stack<>());
        }

        // Add value to frequency stack
        group.get(newFreq).push(val);

        // Update maximum frequency
        maxFreq = Math.max(maxFreq, newFreq);
    }

    public int pop() {

        // Get most recent value
        int val = group.get(maxFreq).pop();

        // Decrease its frequency
        freq.put(val, freq.get(val) - 1);

        // If this frequency stack becomes empty
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}