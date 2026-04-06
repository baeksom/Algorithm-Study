import java.util.*;
import java.io.*;

public class p14500_260406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    static int n, m, max = 0;
    static int[][] arr, ch;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void DFS(int x, int y, int L, int sum) {
        if(L == 4) {
            max = Math.max(max, sum);
        } 
        else {
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny, L+1, sum+ arr[nx][ny]);
                    ch[nx][ny] = 0;
                }
            }
        }
    }
    static void checkT(int x, int y){
        // ㅗ
        if(x-1 >= 0 && y-1 >= 0 && y+1 < m) {
            int sum = arr[x][y] + arr[x-1][y] + arr[x][y-1] + arr[x][y+1];
            max = Math.max(max, sum);
        }
        // ㅜ
        if(x+1 < n && y-1 >= 0 && y+1 < m) {
            int sum = arr[x][y] + arr[x+1][y] + arr[x][y-1] + arr[x][y+1];
            max = Math.max(max, sum);
        }
        // ㅓ
        if(x-1 >= 0 && x+1 < n && y-1 >= 0) {
            int sum = arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y-1];
            max = Math.max(max, sum);
        }
        // ㅏ
        if(x-1 >= 0 && x+1 < n && y+1 < m) {
            int sum = arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y+1];
            max = Math.max(max, sum);
        }
    }
    public static void main(String[] args) throws Exception {
        n = nextInt();
        m = nextInt();
        arr = new int[n][m];
        ch = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = nextInt();
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ch[i][j] = 1;
                DFS(i, j, 1, arr[i][j]);
                ch[i][j] = 0;

                checkT(i, j);
            }
        }

        System.out.println(max);
    }
}
