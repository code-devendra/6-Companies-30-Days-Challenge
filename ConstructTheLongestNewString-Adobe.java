class Solution {
    public int longestString(int x, int y, int z) {
        int ans = 0;
        ans += z*2;
        if(x == y) {
            ans += (x*2 + y*2);
        }else if(x < y) {
            ans += (x*2 + (x+1)*2);
        } else {
            ans += ((y+1)*2 + y*2);
        }
        return ans;
    }
}
