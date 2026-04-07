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

class Route {
    int x;
    String direction;
    Route(int x, String direction) {
        this.x = x;
        this.direction = direction;
    }
}

public class p3190_260407 {
    static int[][] arr;
    static Deque<Route> r;
    static int n;
    static int move() {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int d = 1;
        Deque<Point> q = new ArrayDeque<>();
        q.offerLast(new Point(0, 0));
        arr[0][0] = 1;
        int time = 0;
        while (true) {
            if(!r.isEmpty()) {
                Route curR = r.pollFirst();
                int t = time;
                for(int i=t; i<curR.x; i++) {
                    Point head = q.peekFirst();
                    int nx = dx[d] + head.x;
                    int ny = dy[d] + head.y;
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        return time + 1;
                    } else if (arr[nx][ny] == 1) {
                        return time + 1;
                    } else if (arr[nx][ny] == 2) {
                        // 사과를 먹어
                        q.addFirst(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        time++;
                    } else if (arr[nx][ny] == 0) {
                        // 이동해
                        q.addFirst(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        Point nothere = q.pollLast();
                        arr[nothere.x][nothere.y] = 0;
                        time++;
                    }
                }
                if("D".equals(curR.direction)) {
                    // 오른쪽 90도
                    d = (d + 1) % 4;
                } else if("L".equals(curR.direction)) {
                    // 왼쪽 90도
                    d = (d + 3) % 4;
                }
            } else {
                while (true) {
                    Point head = q.peekFirst();
                    int nx = head.x + dx[d];
                    int ny = head.y + dy[d];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        return time + 1;
                    } else if (arr[nx][ny] == 1) {
                        return time + 1;
                    } else if (arr[nx][ny] == 2) {
                        // 사과 먹어
                        q.offerFirst(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        time++;
                    } else if (arr[nx][ny] == 0) {
                        // 이동해
                        q.offerFirst(new Point(nx, ny));
                        arr[nx][ny] = 1;
                        Point nothere = q.pollLast();
                        arr[nothere.x][nothere.y] = 0;
                        time++;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 2;
        }

        int l = Integer.parseInt(br.readLine());

        r = new ArrayDeque<>();
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            r.offer(new Route(x, dir));
        }   

        System.out.println(move());
    }
}
