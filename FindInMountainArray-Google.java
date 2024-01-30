
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int start = 0, end = n-1, peak = -1;

        // find peak index
        while(start != end) {
            peak = start + (end-start)/2;
            if(mountainArr.get(peak) < mountainArr.get(peak+1)) {
                start = peak+1;
            }else {
                end = peak;
            }
        }

        peak = start;

        // now search in both side one by one

        // left side
        start = 0; 
        end = peak;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } else if(mountainArr.get(mid) > target) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        // right side
        start = peak+1; 
        end = n-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } else if(mountainArr.get(mid) < target) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }

        // target not found
        return -1;
    }
}
