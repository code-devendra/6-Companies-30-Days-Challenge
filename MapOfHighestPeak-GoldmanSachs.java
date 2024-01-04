class Solution {
    boolean isValid(int x, int y, int n, int m, int[][] ans) {
        if(x >= 0 && x < n && y >= 0 && y < m && ans[x][y] == -1) {
            return true;
        }
        return false;
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new Pair(i,j));
                }else {
                    ans[i][j] = -1;
                }
            }
        }
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = (int) p.getKey();
            int y = (int) p.getValue();
            int v = ans[x][y];
            if(isValid(x+1,y,n,m,ans)) {
                ans[x+1][y] = v+1;
                queue.offer(new Pair(x+1,y));
            }
            if(isValid(x-1,y,n,m,ans)) {
                ans[x-1][y] = v+1;
                queue.offer(new Pair(x-1,y));
            }
            if(isValid(x,y+1,n,m,ans)) {
                ans[x][y+1] = v+1;
                queue.offer(new Pair(x,y+1));
            }
            if(isValid(x,y-1,n,m,ans)) {
                ans[x][y-1] = v+1;
                queue.offer(new Pair(x,y-1));
            }
        }
        return ans;
    }
}
