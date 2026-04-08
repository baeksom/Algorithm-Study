import java.util.*;
import java.io.*;
public class p13460_260408 {
    static int n, m;
    static char[][] board;
    static int[][][][] ch;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class State {
        int rx, ry, bx, by, L;
        State(int rx, int ry, int bx, int by, int L) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.L = L;
        }
    }
    static class MoveResult {
        int x, y, dist;
        boolean hole;
        MoveResult(int x, int y, int dist, boolean hole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.hole = hole;
        }
    }
    static MoveResult move(int x, int y, int dir) {
        int dist = 0;
        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(board[nx][ny] == '#') break;
            
            // 이동
            x = nx;
            y = ny;
            dist++;
            
            if(board[x][y] == 'O') {
                return new MoveResult(x, y, dist, true);
            }
        }
        return new MoveResult(x, y, dist,false);
    }
    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(rx, ry, bx, by, 0));
        ch[rx][ry][bx][by] = 1;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if(cur.L >= 10) continue;

            for(int d=0; d<4; d++) {
                MoveResult red = move(cur.rx, cur.ry, d);
                MoveResult blue = move(cur.bx, cur.by, d);

                // 파란색 빠지면 실패
                if(blue.hole) continue;
                // 빨간만 빠지면 성공
                if(red.hole) return cur.L + 1;

                int nrx = red.x;
                int nry = red.y;
                int nbx = blue.x;
                int nby = blue.y;
                if(nrx == nbx && nry == nby) {
                    if(red.dist > blue.dist) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if(ch[nrx][nry][nbx][nby] == 0) {
                    q.offer(new State(nrx, nry, nbx, nby, cur.L+1));
                    ch[nrx][nry][nbx][nby] = 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        ch = new int[n][m][n][m];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        System.out.println(bfs(rx, ry, bx, by));
    }
}