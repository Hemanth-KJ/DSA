import java.util.*;
class Solution {
    public int numSubseq(int[] nums, int target) {
       
       Arrays.sort(nums);

       int n= nums.length;
       int left=0;
       int right=n-1;
       int count = 0;

       long MOD = 1_000_000_007;
       long[] power =new long[n];
       power[0]=1;

       for(int i=1; i<n; i++){
        power[i] = (power[i-1]*2) % MOD;
       }
        while(left <= right){
            if(nums[left]+nums[right] <= target){
                count += power[right-left];
                count %= MOD;
                left++;
            }
            else{
                right--;
            }
        }
        return (int) count;
    } 
}