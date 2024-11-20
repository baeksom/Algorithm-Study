import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int bfs(int f, int s, int g, int u, int d) {
        if (s == g) return 0;  // 시작층과 목표층이 같으면 0초
        
        Queue<Integer> q = new LinkedList<>();
        int[] time = new int[f + 1];
        Arrays.fill(time, -1);  // -1로 초기화하여 방문 여부 확인
        
        q.offer(s);
        time[s] = 0; // 시작층을 0으로 초기화
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] next = {cur + u, cur - d};

            for (int n : next) {
                // 목표층에 도달한 경우
                if (n == g) return time[cur] + 1;
                if (n >= 1 && n <= f && time[n] == -1) {  // 방문하지 않은 층만 탐색
                    q.offer(n);
                    time[n] = time[cur] + 1;
                }
            }
        }

        return -1;  // 목표층에 도달할 수 없는 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int answer = bfs(f, s, g, u, d);
        
        if (answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }
}
