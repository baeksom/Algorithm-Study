import java.io.*;
import java.util.*;

public class p2178_260413 {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0));
        arr[0][0] = 2;
        int time = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                Node cur = q.poll();
                for(int d=0 ; d<4 ; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx == n-1 && ny == m-1) return time+1; 
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
            time++;
        }
        return -1; 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }
}
