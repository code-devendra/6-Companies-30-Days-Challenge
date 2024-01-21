class ThroneInheritance {
    Map<String,Boolean> dead = new HashMap<>();
    Map<String,List<String>> family = new HashMap<>();
    String root;
    public ThroneInheritance(String kingName) {
        root = kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(family.containsKey(parentName)) {
            List<String> list = family.get(parentName);
            list.add(childName);
            family.put(parentName,list);
        }else {
            List<String> list = new ArrayList<>();
            list.add(childName);
            family.put(parentName,list);
        }
    }
    
    public void death(String name) {
        dead.put(name,true);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(ans,root);
        return ans;
    }

    private void dfs(List<String> ans, String root) {
        if(!dead.containsKey(root)) {
            ans.add(root);
        }
        if(family.get(root) == null)    return;
        for(String child: family.get(root)) {
            dfs(ans,child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
