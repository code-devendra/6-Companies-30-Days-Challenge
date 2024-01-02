class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(1,n,k,res,new ArrayList<>());
        return res;
    }
    public void findCombinations(int start, int target,int k, List<List<Integer>> ans, List<Integer> ds){
        if(ds.size() > k)   return;
        if(ds.size() == k && target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = start; i <= 9; i++) {
            ds.add(i);
            findCombinations(i+1,target-i,k,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
