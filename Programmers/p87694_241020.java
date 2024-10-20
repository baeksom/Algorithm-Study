/*
map을 2배 확장한다.
예를 들어, (3,5), (4,5), (3,6), (4,6) 모두 테두리 표시되어있지만, 실제로 (3,5)에서 (3,6)으로 이동할 수 없는 상황이라고 할때
컴퓨터에서는 이동 가능하다고 여길 것이다.
그래서 map을 두배 확장시켜주면 이동 불가능한 곳들이 떨어질 것이다.
*/
import java.util.*;
class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static int[][] map, ch;
    static int answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static int BFS(int characterX, int characterY, int itemX, int itemY) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(characterX, characterY));
        ch[characterX][characterY] = 1;
        answer = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                Point cur = q.poll();
                for(int j=0; j<4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx == itemX && ny == itemY) return ++answer;
                    if(nx >=0 && nx<102 && ny >=0 && ny<102 && ch[nx][ny] == 0 && map[nx][ny] == 1) {
                        ch[nx][ny] = 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
            answer++;
        }
        return 0;
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        ch = new int[102][102];
        for(int[] arr : rectangle) {
            for(int i=arr[0]*2; i<=arr[2]*2; i++) {
                for(int j=arr[1]*2; j<=arr[3]*2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        for(int[] arr : rectangle) {
            for(int i=arr[0]*2+1; i<=arr[2]*2-1; i++) {
                for(int j=arr[1]*2+1; j<=arr[3]*2-1; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer/2;
    }
}