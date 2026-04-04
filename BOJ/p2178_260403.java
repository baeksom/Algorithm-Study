import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p2178_260403 {
    static int[][] arr;
    static int n, m;
    public static int BFS(int x, int y) {
        Deque<Point> q = new ArrayDeque<>();
        q.offerLast(new Point(x, y));
        arr[x][y] = 0;
        int L = 1;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                Point cur = q.pollFirst();
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx == n-1 && ny == m-1) return ++L;
                    else if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.offerLast(new Point(nx, ny));
                    }
                }
            }
            L++;
        } 
        return 0;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(BFS(0,0));
    }
}   
