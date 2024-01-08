class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bullCount = 0;
        int[] g = new int[10];
        int[] s = new int[10];
        for(int i = 0; i < n; i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b) {
                bullCount++;
            }else {
                s[Character.getNumericValue(a)]++;
                g[Character.getNumericValue(b)]++;
            }
        }
        int cowCount = 0;
        for(int i = 0; i < 10; i++) {
            cowCount += Math.min(s[i],g[i]);
        }
        String ans = bullCount + "A" + cowCount + "B";
        return ans;
    }
}
