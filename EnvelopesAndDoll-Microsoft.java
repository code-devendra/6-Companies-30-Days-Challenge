class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    int n = envelopes.length;
    Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    
    int[] tails = new int[n];
    int len = 0;

    for (int[] envelope : envelopes) {
        int index = Arrays.binarySearch(tails, 0, len, envelope[1]);
        if (index < 0) {
            index = -(index + 1);
        }

        tails[index] = envelope[1];
        if (index == len) {
            len++;
        }
    }

    return len;
    }
}
