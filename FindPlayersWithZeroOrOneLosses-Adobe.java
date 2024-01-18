class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossCount = new int[100001];
        int n = matches.length;
        for(int i = 0; i < n; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];
            
            if(lossCount[win] == 0) {
                lossCount[win] = -1;
            }
            if(lossCount[loss] == -1) {
                lossCount[loss] = 1;
            }else {
                lossCount[loss]++;
            }
        }
        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for(int i = 0; i < lossCount.length; i++) {
            if(lossCount[i] == -1) {
                zeroLoss.add(i);
            }else if(lossCount[i] == 1) {
                oneLoss.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);
        return ans;
    }
}
