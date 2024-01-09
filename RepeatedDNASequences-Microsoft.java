class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
        HashMap<String,Integer> map = new HashMap<>();
        int i = 0, j = 9;
        while(j < str.length()) {
            String subStr = str.substring(i,j+1);
            map.put(subStr,map.getOrDefault(subStr,0)+1);
            i++;
            j++;
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> m : map.entrySet()) {
            if(m.getValue() > 1) {
                ans.add(m.getKey());
            }
        }
        return ans;
    }
}
