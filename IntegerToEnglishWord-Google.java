class Solution {
    String ones[] = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

    String tens[] = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

    String thousands[] = {"", " Thousand", " Million", " Billion"};

    String helper(int n) {
        if(n < 20) {
            return ones[n];
        }
        if(n < 100) {
            return tens[n/10] + helper(n%10);
        }
        if(n < 1000) {
            return helper(n/100) + " Hundred" + helper(n%100);
        }
        for(int i = 3; i >= 0; i--) {
            if(n >= Math.pow(1000,i)) {
                return helper(n/(int)Math.pow(1000,i)) + thousands[i] + helper(n % (int)Math.pow(1000,i));
            }
        }
        return "";
    }

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        return helper(num).substring(1);
    }
}
