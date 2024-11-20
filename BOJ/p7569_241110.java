import java.util.*;
class Point {
    public int x,y,z;
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class p7569_241110 {
    static int m,n,h;
    static int[][][] box;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};
    static int[] dz = {-1,1,0,0,0,0};
    public static int bfs() {
        int time = 0;
        int unripeCnt = 0;
        Queue<Point> q = new LinkedList<>();
        for(int z=0; z<h ;z++) {
            for(int x=0; x<n; x++) {
                for(int y=0; y<m; y++) {
                    if(box[z][x][y] == 1) q.offer(new Point(x, y, z));
                    else if(box[z][x][y] == 0) unripeCnt++;
                }
            }
        }
        if(unripeCnt == 0) return 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.println("날짜: " + time);
            System.out.println("---------------");
            for(int i=0; i<len; i++) {
                Point cur = q.poll();
                System.out.println("현재 위치에서 익은 토마토: (" + cur.x + ", " + cur.y + ", " + cur.z + ")");
                for(int d=0; d<6; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    int nz = cur.z + dz[d];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && nz>=0 && nz<h && box[nz][nx][ny] == 0) {
                        box[nz][nx][ny] = 1;
                        q.offer(new Point(nx, ny, nz));
                        unripeCnt--;
                        System.out.println("새로 익은 토마토 위치: (" + nx + ", " + ny + ", " + nz + ")");
                    }
                }
            }
            time++;
            if(unripeCnt == 0) return time;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        box = new int[h][n][m];
        for(int z=0; z<h ;z++) {
            for(int x=0; x<n; x++) {
                for(int y=0; y<m; y++) {
                    box[z][x][y] = sc.nextInt();
                }
            }
        }
        System.out.println(bfs());
    }
}