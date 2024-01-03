class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> hset = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int currCount = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] % p == 0) {
                    ++currCount;
                }
                if(currCount > k) {
                    break;
                }
                sb.append(nums[j] + ",");
                hset.add(sb.toString());
                
            }
        }
        return hset.size();
    }
}
