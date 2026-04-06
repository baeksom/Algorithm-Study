import java.util.*;
import java.io.*;
class Point {
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class p14502_260406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int nextInt() throws IOException {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    static int n, m, virus = 0, answer = 0;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Deque<Point> queue;
    static void DFS(int L) {
        if(L == 3) answer = Math.max(answer, BFS());
        else {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j] == 0) {
                        map[i][j] = 1;
                        DFS(L+1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    static int BFS() {
        Deque<Point> q = new ArrayDeque<>(queue);
        int cnt = virus - 3;
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        while (!q.isEmpty()) {
            int len = q.size();
            while(len-- > 0) {
                Point cur = q.pollFirst();
                for(int d=0; d<4; d++) {
                    int nx = dx[d] + cur.x;
                    int ny = dy[d] + cur.y;
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && copy[nx][ny] == 0) {
                        cnt--;
                        copy[nx][ny] = 2;
                        q.offerLast(new Point(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        n = nextInt();
        m = nextInt();
        map = new int[n][m];
        queue = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int x = nextInt();
                map[i][j] = x;
                if(x == 0) {
                    virus++;
                } else if(x == 2) {
                    queue.offerLast(new Point(i, j));
                }
            }
        }

        DFS(0);
        System.out.println(answer);
    }
}
