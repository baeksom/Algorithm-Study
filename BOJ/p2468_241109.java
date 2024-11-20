import java.util.*;
public class p2468_241109 {
    static int[][] board;
    static int[][] ch;
    static int[] dc = {-1,0,1,0};
    static int[] dr = {0,1,0,-1};
    static int n;
    public static void dfs(int c, int r) {
        for(int i=0; i<4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];
            if(nc>=0 && nc<n && nr>=0 && nr<n && ch[nc][nr] == 0) {
                ch[nc][nr] = 1;
                dfs(nc, nr);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
                if(max < board[i][j]) max = board[i][j];
            }
        }
        int maxT = 0;
        // 높이 h에 대해 각 안전한 영역을 찾아본다(완전탐색)
        for(int h=0; h<max; h++) { // 높이가 0인 것도 고려해야함, 최대면 영역이 0이므로 할 필요 없음
            ch = new int[n][n];
            int cnt = 0;
            
            // 높이가 h이하인 곳 잠긴 곳(1)으로 표시
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(board[i][j] <= h) ch[i][j] = 1;
                }
            }

            // 잠기지 않은 영역(0)을 찾으면서 DFS 실행
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(ch[i][j] == 0) {
                        cnt++;
                        ch[i][j] = 1;
                        dfs(i,j); // 연결된 영역 모두 방문 체크
                    }
                }
            }
            maxT = Math.max(maxT, cnt);
        }
        System.out.println(maxT);
    }
}