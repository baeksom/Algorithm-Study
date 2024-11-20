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
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int unripened = 0;
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<n ;i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1) q.offer(new Point(i, j));
                else if(board[i][j] == 0) unripened++;
            }
        }
        if(unripened == 0) {
            System.out.println(0);
            return;
        }
        
        int time = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                Point cur = q.poll();
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                        unripened--;
                    }
                }
            }
            time++;
            if(unripened == 0) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }
}
