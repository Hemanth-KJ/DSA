class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

       List<Integer>[] buckets = new List[nums.length+1];

       for(int num : map.keySet()){
         int Frequency= map.get(num);
          if(buckets[Frequency] == null){
            buckets[Frequency] = new ArrayList<>();
          }
          buckets[Frequency].add(num);
       }
          
        int[] result = new int[k];
        int index=0;
        for(int Frequency=nums.length; Frequency>=1; Frequency--){
            if(buckets[Frequency] != null){
                for(int num: buckets[Frequency]){
                 result[index]= num;
                index++;

                if(index == k){
                    return result;
                }
            }
        }
        }
        
        return result;

    }
}