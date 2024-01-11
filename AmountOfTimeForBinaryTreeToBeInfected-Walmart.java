class Solution {
    int time = -1;
    void dfs(TreeNode root, TreeNode parent, Map<Integer,List<Integer>> adj) {
        if(root == null)    return;
        if(parent != null) {
            if(adj.containsKey(parent.val)) {
                List<Integer> list = adj.get(parent.val);
                list.add(root.val);
                adj.put(parent.val,list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                adj.put(parent.val,list);
            }
            if(adj.containsKey(root.val)) {
                List<Integer> list = adj.get(root.val);
                list.add(parent.val);
                adj.put(root.val,list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(parent.val);
                adj.put(root.val,list);
            }
        }
        dfs(root.left,root,adj);
        dfs(root.right,root,adj);
    }
    void graphBfs(int source, Map<Integer,List<Integer>> adj, Set<Integer> visited, int curr_distance) {
        if(visited.contains(source)) {
            time = Math.max(time,curr_distance);
            return;
        }
        visited.add(source);
        for(int i : adj.get(source)) {
            graphBfs(i,adj,visited,curr_distance+1);
        }
        visited.remove(source);
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root.left == null && root.right == null) return 0;
        Map<Integer,List<Integer>> adj = new HashMap<>();
        dfs(root,null,adj);
        Set<Integer> visited = new HashSet<>();
        graphBfs(start,adj,visited, -1);
        return time;
    }
}
