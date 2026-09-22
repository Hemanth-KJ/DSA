class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
       int targetSum= threshold * k;
       int count=0;
       int windowSum=0;
       for(int i=0; i<k; i++){
        windowSum += arr[i];
       }
       if(windowSum >=targetSum){
        count++;
       }
        for(int right=k; right<arr.length; right++){
        windowSum += arr[right];
        windowSum -= arr[right - k];
         
         if(windowSum >= targetSum){
            count++;
         }
        } 
        
        return count;
    }
}