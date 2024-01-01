class Solution {
    int gcd(int n1, int n2) {
        if(n2 == 0) return n1;
        return gcd(n2,n1%n2);
    }
    int lcm(int n1, int n2) {
        long temp = (long) (n1/gcd(n1,n2)) * n2;
        return temp > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) temp;
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int l = uniqueCnt1 + uniqueCnt2 - 1;
        int h = Integer.MAX_VALUE;
        int LCM = lcm(divisor1, divisor2);
        while(l <= h) {
            int m = l + (h-l)/2;
            int a = m - (m/divisor1);
            int b = m - (m/divisor2);
            if(a >= uniqueCnt1 && b >= uniqueCnt2 && (m - (m/LCM)) >= (uniqueCnt1+uniqueCnt2)) {
                h = m-1;
            }else {
                l = m+1;
            }
        }
        return l;
    }
}
