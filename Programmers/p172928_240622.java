import java.util.HashMap;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int h = park.length, w = park[0].length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('N',0);
        map.put('E',1);
        map.put('S',2);
        map.put('W',3);
        
        int r = 0, c = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] str = route.split(" ");
            int n = Integer.parseInt(str[1]);
            char op = str[0].charAt(0);
            int nr = r;
            int nc = c;
            boolean flag = true;
            for (int i=0; i<n; i++) {
                nr += dr[map.get(op)];
                nc += dc[map.get(op)];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w || park[nr].charAt(nc) == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                r = nr;
                c = nc;
            }
        }
        answer[0] = r;
        answer[1] = c;
        return answer;
    }
}