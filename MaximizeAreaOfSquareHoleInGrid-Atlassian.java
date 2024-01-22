class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hx = 0, hy = 0;
        int maximumHbars = 1;
        while(hy < hBars.length) {
            if(hy == hx || hBars[hy] == hBars[hy-1]+1) {
                maximumHbars = Math.max(maximumHbars,hy-hx+2);
                hy++;
            }else {
                hx = hy;
            }
        }

        int vx = 0, vy = 0;
        int maximumVbars = 1;
        while(vy < vBars.length) {
            if(vy == vx || vBars[vy] == vBars[vy-1]+1) {
                maximumVbars = Math.max(maximumVbars,vy-vx+2);
                vy++;
            }else {
                vx = vy;
            }
        }

        int result = Math.min(maximumHbars,maximumVbars);

        return result*result;
    }
}
