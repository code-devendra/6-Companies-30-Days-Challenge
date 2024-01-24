class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int ans = 0;
        int count = 0;
        int i = 0, j = 0;
        int n = nums.length;
        while(j < n) {
            if(freq.containsKey(nums[j]) && freq.get(nums[j]) == k) {
                while(freq.get(nums[j]) != k-1) {
                    freq.put(nums[i],freq.get(nums[i])-1);
                    count--;
                    i++;
                }
            }
            freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            count++;
            ans = Math.max(ans,count);
            j++;
        }
        return ans;
    }
}
