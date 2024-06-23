import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 최소 누름 횟수 
        for (String s : keymap) {
            for (int i=0 ; i<s.length(); i++) {
                if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) > i+1) {
                    map.put(s.charAt(i), i+1);
                }
            }
        }
        
        for (int i=0 ; i<targets.length; i++){
            int cnt = 0;
            for (int j=0; j<targets[i].length(); j++) {
                if (map.containsKey(targets[i].charAt(j))) {
                    cnt += map.get(targets[i].charAt(j));
                } else {
                    // 작성 불가능한 문자열
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}