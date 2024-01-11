class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        Map<Integer,Integer> freq = new HashMap<>();
        for(int item : pq) {
            freq.put(item,freq.getOrDefault(item,0)+1);
        }
        int[] seq = new int[k];
        int i = 0;
        for(int num : nums) {
            if(freq.containsKey(num) && freq.get(num) != 0) {
                seq[i++] = num;
                freq.put(num,freq.get(num) -1);
            }
        }
        return seq;
    }
}
