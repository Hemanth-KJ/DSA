class Solution {
    public int compress(char[] chars) {
        int read=0;
        int write=0;

        while(read < chars.length){
            char currentchar= chars[read];
            int count=0;

            while(read < chars.length && chars[read] == currentchar ){
                read++;
                count++;
            }
           
           chars[write++] =currentchar;

           if(count > 1){
            String countString=String.valueOf(count);

            for(int i=0; i<countString.length(); i++){
                chars[write++] = countString.charAt(i);
            }
           }
        }
        return write;
    }
}