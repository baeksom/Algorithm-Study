import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        // hashmap 초기화
        String str = "RTCFJMAN";
        for(char c : str.toCharArray()) {
            map.put(c, 0);
        }
        
        // 두번째 지표에 점수 주기 (첫번째 지표가 점수를 획득하더라도 그 절대값만큼 두번째 지표에 음수값이 더해지게)
        for(int i=0; i<survey.length; i++) {
            char c = survey[i].charAt(1);
            map.put(c, map.get(c) + choices[i] - 4);
        }
        System.out.println(map);
        
        StringBuilder sb = new StringBuilder();
        char c = (map.get('R') >= map.get('T')) ? 'R' : 'T';
        sb.append(c);
        c = (map.get('C') >= map.get('F')) ? 'C' : 'F';
        sb.append(c);
        c = (map.get('J') >= map.get('M')) ? 'J' : 'M';
        sb.append(c);
        c = (map.get('A') >= map.get('N')) ? 'A' : 'N';
        sb.append(c);
        
        return sb.toString();
    }
}