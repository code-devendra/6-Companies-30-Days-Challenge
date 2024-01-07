class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n/2; i++) {
            ans += (nums[n-1-i] - nums[i]);
        }
        return ans;
    }
}
