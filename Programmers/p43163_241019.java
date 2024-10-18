// BFS 사용 
import java.util.*;
class Solution {
    public boolean checkWords(String begin, String word) {
        // 문자가 하나만 다른지 확인
        int cnt = 0;
        for(int i=0; i<begin.length(); i++) {
            if(begin.charAt(i) != word.charAt(i)) cnt++;
        }
        return (cnt==1) ? true : false;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] ch = new int[words.length];
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                String cur = q.poll();
                for(int j=0; j<words.length; j++) {
                    if(checkWords(cur, words[j]) && ch[j] == 0){
                        if(words[j].equals(target)) return ++answer;
                        ch[j] = 1;
                        q.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}