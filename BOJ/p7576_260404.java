import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point {
    int x, y;
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class p7576_260404 {
    static int n, m;
    static int[][] arr;
    static Deque<Point> q;
    public static int BFS() {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            boolean ripened = false;
            for(int i=0; i<len; i++) {
                Point cur = q.pollFirst();
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                        q.offerLast(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        ripened = true;
                    }
                }
            }
            if(ripened) L++;
        }

        boolean flag = true;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    flag = false;
                } 
            }
        }

        if(flag) return L;
        else return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        q = new ArrayDeque<>();
        boolean noripened = true;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.offerLast(new Point(i, j));
                } 
                else if (noripened && arr[i][j] == 0) {
                    noripened = false;
                }
            }
        }
        
        if(noripened) System.out.println(0);
        else System.out.println(BFS());
    }
}
