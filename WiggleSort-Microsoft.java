class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int i = 1;
        int j = n-1;
        while(i < n) {
            nums[i] = temp[j];
            i += 2;
            j--;
        }
        i = 0;
        while(i < n) {
            nums[i] = temp[j];
            i += 2;
            j--;
        }
    }
}
