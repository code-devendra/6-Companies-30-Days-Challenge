class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String,ArrayList<Integer>> personsList = new HashMap<>();
        for(int i = 0; i < access_times.size(); i++) {
            String personName = access_times.get(i).get(0);
            int accessTime = Integer.parseInt(access_times.get(i).get(1));
            if(personsList.containsKey(personName)) {
                personsList.get(personName).add(accessTime);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(accessTime);
                personsList.put(personName,list);
            }
        }
        List<String> ansList = new ArrayList<>();
        int DIFF = 99;
        for(Map.Entry<String,ArrayList<Integer>> map : personsList.entrySet()) {
            ArrayList<Integer> currList = map.getValue();
            if(currList.size() < 3) {
                continue;
            }else {
                Collections.sort(currList);
                int s = 0;
                int e = 2;
                while(e < currList.size() && e-s >= 2) {
                    int timePeriod = currList.get(e) - currList.get(s);
                    if(timePeriod > DIFF) {
                        s++;
                        e++;
                    } else {
                        ansList.add(map.getKey());
                        break;
                    }
                }
            }
        }
        return ansList;

    }
}
