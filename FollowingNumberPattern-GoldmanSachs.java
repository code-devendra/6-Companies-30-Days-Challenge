class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        char[] ans = new char[S.length() + 1];
        for(int i = 1; i <= S.length()+1; i++) {
            ans[i-1] = (char) ('0' + i);
        }
        while(true) {
            int j = 1, k = 0;
            boolean f = true;
            while(j < ans.length) {
                if(S.charAt(k) == 'D' && ans[j] > ans[j-1]) {
                    char temp = ans[j];
                    ans[j] = ans[j-1];
                    ans[j-1] = temp;
                    f = false;
                }
                if(S.charAt(k) == 'I' && ans[j] < ans[j-1]) {
                    char temp = ans[j];
                    ans[j] = ans[j-1];
                    ans[j-1] = temp;
                    f = false;
                }
                j++;
                k++;
            }
            if(f == true)   break;
        }
        String res = new String(ans);
        return res;
    }
}
