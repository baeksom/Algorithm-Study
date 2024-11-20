import java.util.*;
class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] visited;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] board = new int[n][m];
        int[][] ch = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] = sc.nextInt();
                ch[i][j] = board[i][j];
            }
        }
        
        int year = 0;
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] > 0) q.offer(new Point(i, j));
            }
        }

        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                Point cur = q.poll();
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0) {
                        if(ch[cur.x][cur.y] > 0) ch[cur.x][cur.y] -= 1;
                    }
                }
            }
            year++;

            visited = new int[n][m];
            // 갱신
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    board[i][j] = visited[i][j] = ch[i][j];
                    if (board[i][j] > 0) q.offer(new Point(i, j));
                }
            }

            // 분리되었는지 확인
            int cnt = 0;

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(visited[i][j] > 0) {
                        cnt++;
                        visited[i][j] = 0;
                        dfs(i, j, board);
                    }
                }
            }
            System.out.println("cnt : " + cnt);
            if(cnt > 1) {
                System.out.println(year);
                return;
            }
            
        }
        System.out.println(0);
    }
    public static void dfs(int x, int y, int[][] board) {
        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(visited[nx][ny] != 0) {
                visited[nx][ny] = 0;
                dfs(nx, ny, board);
            }
        }
    }
}