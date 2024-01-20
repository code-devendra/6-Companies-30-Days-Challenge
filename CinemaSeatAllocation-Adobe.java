class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int result = 0;
        Map<Integer, Set<Integer>> rowToSeatRes = new HashMap<>();
        
        for(int[] row : reservedSeats) {
            if(rowToSeatRes.containsKey(row[0])) {
                rowToSeatRes.get(row[0]).add(row[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(row[1]);
                rowToSeatRes.put(row[0], set);
            }
        }
        result = (n - rowToSeatRes.size()) * 2; 
        
       for(Set<Integer> res : rowToSeatRes.values()) { 
            boolean flag = false;
            if(!res.contains(2) &&
              !res.contains(3) &&
              !res.contains(4) &&
              !res.contains(5)) {
                result++;
                flag = true;
            }
            
            if(!res.contains(6) &&
              !res.contains(7) &&
              !res.contains(8) &&
              !res.contains(9)) {
                result++;
                flag = true;
            }

            if(!flag) {
                if(!res.contains(4) &&
                   !res.contains(5) &&
                   !res.contains(6) &&
                   !res.contains(7))
                result++;
            }
        }
        
        return result;
    }
}
