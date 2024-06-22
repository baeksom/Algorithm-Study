import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int key : map.keySet()) {
            if(max < map.get(key)) max = map.get(key);
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == max) {
                al.add(key);
            }
        }
        
        if(al.size() > 1) answer = -1;
        else answer = al.get(0);
        return answer;
    }
}