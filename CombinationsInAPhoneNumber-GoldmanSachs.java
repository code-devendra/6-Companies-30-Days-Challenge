class Solution {
    private String[] digits = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private void helper(String str, String temp, int ind, List<String> ans) {
        if(ind == str.length()) {
            ans.add(temp);
            return;
        }
        for(int i = 0; i < digits[Integer.parseInt(str.charAt(ind) + "")].length(); i++) {
            String s = digits[Integer.parseInt(str.charAt(ind) + "")];
            helper(str,temp + s.charAt(i), ind+1,ans);
        }
    }
    public List<String> letterCombinations(String dig) {
        List<String> ans = new ArrayList<>();
        if(dig.length() == 0)   return ans;
        helper(dig,"",0,ans);
        return ans;
    }
}
