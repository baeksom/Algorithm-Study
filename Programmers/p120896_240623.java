import java.util.*;
class Solution {
    public String solution(String s) {
        // HashMap 생성 및 초기화
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 한 번만 등장하는 문자
        StringBuilder sb = new StringBuilder();
        for(char c : map.keySet()) {
            if(map.get(c) == 1) {
                sb.append(c);
            }
        }
        
        // 문자열 정렬
        String tmp = sb.toString();
        char[] answer = tmp.toCharArray();
        Arrays.sort(answer);
        return String.valueOf(answer);
    }
}