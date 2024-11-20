import java.util.*;
class Location {
    public int x, y;
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class p9205_241111 {
    static int n;
    static ArrayList<Location> al;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int t=0; t<test_case; t++) {
            al = new ArrayList<>();
            int s = sc.nextInt(); // 편의점 개수
            al.add(new Location(sc.nextInt(), sc.nextInt()));
            for(int j = 1; j<=s; j++) {
                al.add(new Location(sc.nextInt(), sc.nextInt()));
            }
            al.add(new Location(sc.nextInt(), sc.nextInt()));

            int[][] graph = new int[s+2][s+2]; //0 - 집, 1 - 편의점 2 - 편의점, 3 - 페스티벌
            for(int i=0; i<al.size(); i++) {
                Location cur = al.get(i);
                for(int j=0; j<al.size(); j++) {
                    Location c = al.get(j);
                    if(i != j) {
                        graph[i][j] = Math.abs(cur.x-c.x)+Math.abs(cur.y-c.y);
                        graph[j][i] = Math.abs(cur.x-c.x)+Math.abs(cur.y-c.y);
                    }
                }
            }
            int[] ch = new int[s+2]; // 방문했는지 체크
            if(graph[0][s+1]<=50*20) {
                System.out.println("happy");
                continue;
            }
            // bfs 실행
            Queue<Integer> q = new LinkedList<>();
            q.offer(0); // 집에서 시작
            ch[0] = 1;

            while (!q.isEmpty()) {
                int len = q.size();
                for(int i=0; i<len; i++) {
                    int cur = q.poll();
                    for(int j=1; j<=s+1; j++) {
                        if(cur != j && ch[j] == 0 && graph[cur][j] <= 50*20) {
                            ch[j] = ch[cur] + graph[cur][j]-1;
                            q.offer(j);
                        }
                    }
                }
            }
            if(ch[s+1] > 0 ) System.out.println("happy");
            else System.out.println("sad");
        }

    }
}