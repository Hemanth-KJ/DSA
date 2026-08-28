class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);

        set.remove(beginWord);

        int steps=1;

        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
            String current=queue.poll();

            if(current.equals(endWord)){
             return steps;   
            }

             char[] chars =current.toCharArray();
             for(int j=0; j<chars.length; j++){
                char Original=chars[j];
               for(char c='a'; c<='z'; c++){
                if(c == Original){
                    continue;
                }
                chars[j]=c;

                String next= new String(chars);

                if(set.contains(next)){
                    queue.offer(next);

                    set.remove(next);
                }
               }
              chars[j]=Original;
             }
            }
            steps++;
        }
    return 0;
    }
}