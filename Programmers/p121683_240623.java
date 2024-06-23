import java.util.*;
class Solution {
    public String solution(String input_string) {
        // 0번째 문자는 무조건 해싱, 카운팅
        // 1번째 문자부터 끝까지 for문 돌면서 전 문자와 비교해서 다르면 빈도수 카운팅
        // 전 문자와 같으면 지나감
        // 빈도수가 2 이상인 친구들만 외톨이임
        // key들을 append해서 sorting
        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(input_string.charAt(0), 1);
        for(int i=1; i<input_string.length(); i++){
            if(input_string.charAt(i-1) != input_string.charAt(i)){
                map.put(input_string.charAt(i), map.getOrDefault(input_string.charAt(i),0)+1);
            }
        }
        for(char key : map.keySet()){
            if(map.get(key) > 1){
                sb.append(key);
            }
        }
        answer = sb.toString();
        if(answer.equals("")){
            return "N";
        }
        char[] tmp = answer.toCharArray();
        Arrays.sort(tmp);
        answer = String.valueOf(tmp);
        return answer;        
    }
}