class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        // cnt는 입력할 숫자, d는 방향 (초기에는 오른쪽을 향하고 있음)
        int cnt = 1, d = 1;
        int r = 0, c = 0;
        answer[r][c] = cnt;
        while (cnt != n*n) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr>=0 && nr<n && nc>=0 && nc<n && answer[nr][nc] == 0) {
                r = nr;
                c = nc;
                answer[r][c] = ++cnt;
            } else {
                d = (d+1) %4;
            }
        }
        
        return answer;
    }
}