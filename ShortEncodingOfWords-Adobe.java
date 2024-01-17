class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = 0; j < n; j++){
                int iLen = words[i].length();
                int jLen = words[j].length();
                if(i != j && words[j] != "-1" && iLen <= jLen) {
                    String subStr = words[j].substring(jLen-iLen,jLen);
                    if(subStr.equals(words[i])) {
                        words[i] = "-1";
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) {
                ans += (words[i].length() + 1);
            }
        }
        return ans;
    }
}
