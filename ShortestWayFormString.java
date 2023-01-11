//Time O(N Log N)
//Space O(N)


import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, TreeSet<Integer>> ocm = new HashMap<>();
        int slen = source.length();
        int tlen = target.length();
        int answer = 1;
        for(int i=0;i<slen;i++) {
            Character ch = source.charAt(i);
            TreeSet<Integer> indices = ocm.getOrDefault(ch, new TreeSet<Integer>());
            indices.add(i);
            ocm.put(ch, indices);
        }
        int prevUtilized = -1;
        for(int i=0;i<tlen;i++) {
            Character ch = target.charAt(i);
            if(!ocm.containsKey(ch)) {
                return -1;
            }
            Integer newIdx = ocm.get(ch).higher(prevUtilized);
            if(newIdx == null) {
                answer++;
                newIdx = ocm.get(ch).ceiling(-1);
            }
            prevUtilized = newIdx;
        }
        return answer;
    }
}