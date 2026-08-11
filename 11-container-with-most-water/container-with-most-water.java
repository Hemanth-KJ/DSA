class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        int left =0;
        int right =height.length - 1;
        while(left < right){
           
            int w = right-left;

            int h = Math.min(height[left], height[right]);

            int currwater = h*w;
            maxArea =Math.max(maxArea, currwater);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return maxArea;
    }
}