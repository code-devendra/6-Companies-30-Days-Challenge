class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance = 0;
        int n = arr1.length;
        int m = arr2.length;
        Arrays.sort(arr2);
        for(int i = 0; i < n; i++) {
            int low = arr1[i] - d;
            int high = arr1[i] + d;
            int s = 0, e = m-1;
            boolean flag = true;
            while(s <= e) {
                int mid = (s+e)/2;
                if(arr2[mid] <= high && arr2[mid] >= low) {
                    flag = false;
                    break;
                }else if(arr2[mid] > high) {
                    e = mid-1;
                }else   s = mid+1;
            }
            if(flag)    distance++;
        }
        return distance;
    }
}
