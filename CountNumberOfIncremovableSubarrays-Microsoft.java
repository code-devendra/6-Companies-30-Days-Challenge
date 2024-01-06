class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                boolean ok = true;
                int lastNum = -1;

                for(int k = 0; k < n; k++) {
                    if(k >= i && k <= j) {
                        continue;
                    }else {
                        if(!(lastNum < nums[k])){
                            ok = false;
                            break;
                        }
                        lastNum = nums[k];
                    }
                }
                if(ok) ans += 1;
            }
        }
        return ans;
    }
}
