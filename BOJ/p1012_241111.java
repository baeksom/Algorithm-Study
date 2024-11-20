import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class p1012_241111 {
    static int[][] board;
    static int n, m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        for(int t=0; t<test_case; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int lc = Integer.parseInt(st.nextToken());
            board = new int[n][m];
            for(int i=0; i<lc; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()); 
                board[b][a] = 1;
            }

            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(board[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}