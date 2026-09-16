class FreqStack {
    private Map<Integer, Integer> freq;
    private Map<Integer, Stack<Integer>> group;
    private int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq =0;
        
    }
    
    public void push(int val) {
       int  newfreq = freq.getOrDefault(val, 0)+1;
        
        freq.put(val, newfreq);

        if(!group.containsKey(newfreq)){
            group.put(newfreq, new Stack<>());
        }

        group.get(newfreq).push(val);
        maxfreq=Math.max(maxfreq, newfreq);

    }
    
    public int pop() {
        int val= group.get(maxfreq).pop();

        freq.put(val, freq.get(val)-1);

        if(group.get(maxfreq).isEmpty()){
            maxfreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */