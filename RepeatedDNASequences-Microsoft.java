class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
        HashMap<String,Integer> map = new HashMap<>();
        int s = 0, e = 9;
        while(e < str.length()) {
            String subStr = str.substring(s,e+1);
            map.put(subStr,map.getOrDefault(subStr,0)+1);
            s++;
            e++;
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
